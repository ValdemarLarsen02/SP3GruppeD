package src;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

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
            return new Movies(title, releaseYear, category, rating);
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
            Shows show = new Shows(title, releaseYear, category, rating);

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




    void saveMediaData(String title){

    }

    void saveUserData(String username, String password){

    }


}
