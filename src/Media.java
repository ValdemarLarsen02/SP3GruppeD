package src;

import java.util.ArrayList;
import java.util.List;

public abstract class Media {
    Util util = new Util();
    FileIO fileIO = new FileIO();

    private int releaseYear;
    String title;
    ArrayList<Category> categories;
    private double rating;

    public Media(String title, int releaseYear, ArrayList<Category> categories, double rating) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.categories = categories;
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
        fileIO.saveMediaData(this.title, this.releaseYear, this.categories, this.rating);
        util.displayMsg("You have already watched " + this.title);
    }


    void watch(String title) {
        util.displayMsg("You are now watching " + title + "!");
    }


    // I Media klassen
    public static List<Media> loadMedia(String pathToFile) {
        FileIO fileIO = new FileIO();
        return fileIO.readFile(pathToFile);
    }

    public void displayMediaList(List<Media> mediaList, int startIndex, int count) {
        for (int i = startIndex; i < startIndex + count && i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            System.out.println((i + 1) + ". Title: " + media.getTitle() + ", Udgivelse år: " + media.getReleaseYear() + ", Kategori: " + media.getCategory() + ", Scorer: " + media.getRating());
        }
    }


    public void searchMediaByTitle(List<Media> mediaList, String title) {
        System.out.println("Kører koden");
        for (int i = 0; i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            if (media.getTitle().equals(title)) {
                System.out.println((i + 1) + ". Title: " + media.getTitle());
            }
        }
    }




    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Category> getCategory() {
        return categories;
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

