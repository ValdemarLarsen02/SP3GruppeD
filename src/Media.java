package src;

import java.util.ArrayList;
import java.util.List;

public abstract class Media {
    Util util = new Util();
    FileIO fileIO = new FileIO();

    private int releaseYear;
    private String title;
    private String category;
    private double rating;

    public Media(String title, int releaseYear, String category, double rating) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    void watchLater(User user) {
       // watchLaterList.add(user);
        util.displayMsg("You have added " + this.title + " to your watch list.");
    }

    void removeFromWatchLater(User user) {
        //watchLaterList.remove(user);
        util.displayMsg("You have removed " + this.title + " from the watch list.");
    }

    void alreadyWatched(User user) {
        fileIO.saveMediaData(this.title, this.releaseYear, this.category, this.rating);
        util.displayMsg("You have already watched " + this.title);
    }


    void watch() {
        util.displayMsg("You are now watching " + this.title + "!");
    }


    // I Media klassen
    public static List<Media> loadMedia(String pathToFile) {
        FileIO fileIO = new FileIO();
        return fileIO.readFile(pathToFile);
    }

    public void displayMedia(int startIndex, int count) {
        List<Media> mediaList = loadMedia(this.getClass().getSimpleName().toLowerCase() + ".txt"); // Dette vil vælge filnavnet baseret på klassenavnet
        displayMediaList(mediaList, startIndex, count);
    }

    public void displayMediaList(List<Media> mediaList, int startIndex, int count) {
        for (int i = startIndex; i < startIndex + count && i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            System.out.println((i + 1) + ". Title: " + media.getTitle() + ", Release Year: " + media.getReleaseYear() + ", Category: " + media.getCategory() + ", Rating: " + media.getRating());
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

   /* public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }*/
}

