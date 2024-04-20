package src;

import java.util.ArrayList;
import java.util.List;

public abstract class Media {
    Util util = new Util();

    private int releaseYear;
    private String title;
    private String category;
    private double rating;
    private List<User> watchLaterList = new ArrayList<>();
    private List<User> alreadyWatchedList = new ArrayList<>();

    public Media(String title, int releaseYear, String category, double rating) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    void watchLater(User user) {
        watchLaterList.add(user);
        util.displayMsg("You have added " + this.title + " to your watch list.");
    }

    void removeFromWatchLater(User user) {
        watchLaterList.remove(user);
        util.displayMsg("You have removed " + this.title + " from the watch list.");
    }

    void alreadyWatched(User user) {
        alreadyWatchedList.add(user);
        util.displayMsg("You have already watched " + this.title);
    }


    void watch() {
        util.displayMsg("You are now watching " + this.title + "!");
    }

    int i = 0;
    void turnPage() {

        for (int j = i; j < i + 10 && j < movie.size(); j++) {
            System.out.println((movie.get(j)));

        }
        i += 10;
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

