package src;

import java.util.ArrayList;
import java.util.List;

public abstract class Media {

    protected int releaseYear;
    protected String title;
    protected String category;
    protected double rating;
    protected List<User> watchLaterList;
    protected List<User> alreadyWatchedList;

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
}

