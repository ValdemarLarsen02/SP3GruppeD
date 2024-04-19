package src;

import java.util.ArrayList;
import java.util.List;

public abstract class Media {

    private int releaseYear;
    private String title;
    private String category;
    private double rating;
    private List<User> watchLaterList;
    private List<User> alreadyWatchedList;

    public Media(String title, int releaseYear, String category, double rating) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    void watchLater(User user) {
        watchLaterList.add(user);
    }

    void removeFromWatchLater(User user) {
        watchLaterList.remove(user);
    }

    void alreadyWatched(User user) {
        alreadyWatchedList.add(user);
    }

    void watch() {
        String msg = "You are now watching " + this.title + "!";
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

    public void setReleaseYear(int releaseYear) {
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
    }
}

