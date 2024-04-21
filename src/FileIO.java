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
        File file = new File(path);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                handleFetchedData(line, mediaList);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet i følgende sti " + path + " " + e.getMessage());
            return null;
        }

        return mediaList;
    }


    /*
        val
     */
    private void handleFetchedData(String line, List<Media> mediaList) {
        String[] data = line.split(";");
            if (data.length == 4) {
                int releaseYear = Integer.parseInt(data[1].substring(0,4).trim()); // Giver os det første år.
                String title = data[0].trim();
                String category = data[2].trim();
                double rating = Double.parseDouble(data[3].trim().replace(',', '.'));


                Movies movie = new Movies(title, releaseYear, category, rating);
                mediaList.add(movie);
            } else if (data.length == 5) {
                int releaseYear = Integer.parseInt(data[1].substring(0, 4).trim());
                String title = data[0].trim();
                String category = data[2].trim();
                String episodes = data[4].trim();
                // data til Shows
            }


    }

    void saveMediaData(String title){

    }

    void saveUserData(String username, String password){

    }


}
