package src;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    private String mediaDataPath = "data/MediaData.csv";
    Util ui = new Util();

    // Læser filen udfra given path og returner den data der er blevet hentet i en Arraylist.
    public List<Media> readFile(String path) {
        List<Media> mediaList = new ArrayList<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Media media = parseLine(line, path);
                if (media != null) {
                    mediaList.add(media);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke hentet. " + e.getMessage());
        }
        return mediaList;
    }


    private Media parseLine(String line, String path) {
        String[] data = line.split("; ");

        if (path.contains("film.txt")) {
            if (data.length != 4) {
                System.err.println("Ugyldig linjeformat for film: " + line);
                return null;
            }
            String title = data[0].trim();
            int releaseYear = Integer.parseInt(data[1].trim());
            String category = data[2].trim();
            String ratingStr = data[3].trim();
            ratingStr = ratingStr.replace(',', '.'); // Erstat komma med punktum
            double rating = Double.parseDouble(ratingStr.replaceAll("[^\\d.]", ""));
            ArrayList<Category> categories = getCategories(category);
            return new Movies(title, releaseYear, categories, rating);
        } else if (path.contains("serier.txt")) {
            if (data.length != 5) {
                System.err.println("Ugyldig linjeformat for serier: " + line);
                return null;
            }
            String title = data[0].trim();
            String tempReleaseYear = data[1].trim();
            int releaseYear = Integer.parseInt(tempReleaseYear.split("-")[0]);
            String category = data[2].trim();
            String ratingStr = data[3].trim();
            ratingStr = ratingStr.replace(',', '.'); // Erstat komma med punktum
            double rating = Double.parseDouble(ratingStr);
            ArrayList<Category> categories = getCategories(category);
            Shows show = new Shows(title, releaseYear, categories, rating);

            String seasonsData = data[4].trim();
            seasonsData = seasonsData.replace(";", ""); // Fjerner det semikolan der er for enden af hver linje
            String[] seasonPairs = seasonsData.split(",\\s*"); // Splitter op ved komma samt fjerner det mellerum der er.
            for (String pair : seasonPairs) {
                String[] seasonInfo = pair.split("-");
                if (seasonInfo.length == 2) {
                    try {
                        int seasonNumber = Integer.parseInt(seasonInfo[0].trim());
                        int episodeCount = Integer.parseInt(seasonInfo[1].trim());
                        show.addSeason(seasonNumber, episodeCount);
                    } catch (NumberFormatException e) {
                        System.err.println("Fejl dat season og epsiode skulle hentes.. " + e.getMessage());
                    }
                } else {
                    System.err.println("Ugyldigt format for sæson-episode: " + pair);
                }
            }

            return show;
        }

        return null;
    }





    /*
        val
     */

    public static ArrayList<Category> getCategories(String data) {
        String[] categoriesData = data.split(",");
        ArrayList<Category> categories = new ArrayList<>();
        for(String s : categoriesData) {
            categories.add(Category.findCategory(s));
        }
        return categories;
    }


    void saveMediaData(String title, int releaseYear, ArrayList<Category> category, double rating) {
        try {
            FileWriter fw = new FileWriter(mediaDataPath, true);
            fw.write("title, releaseYear, category, rating\n");
            fw.write(title + "," + releaseYear + "," + category + "," + rating + "\n");
            fw.close();
        } catch (IOException e) {
            ui.displayMsg("Dataen blev ikke gemt " + e.getMessage());
        }
    }

    void saveUserData(String username, String password, String path){
        try {
            FileWriter fw = new FileWriter(path, true); // 'true' for at tilføje til filen i stedet for at overskrive
            fw.write(username + "," + password + "\n"); // Tilføj '\n' for at sikre ny linje
            fw.flush();
            fw.close(); // Det er god praksis at lukke FileWriter efter brug
        } catch (IOException e) {
            ui.displayMsg("Dataen blev ikke gemt " + e.getMessage());
        }
    }


    public void addWatchLater(User user, Media media) {
        String title = media.getTitle();
        String username = user.getLoggedInUsername();

        try (FileWriter writer = new FileWriter("data/watch_later.csv", true)) {
            writer.append(username);
            writer.append(",");
            writer.append(title);
            writer.append("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
