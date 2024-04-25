package src;

import java.util.ArrayList;
import java.util.List;

public class Movies extends Media{

    public Movies(String title, int releaseYear, ArrayList<Category> category, double rating) {
        super(title,
                releaseYear,
                category,
                rating);
    }

    @Override
    void watchLater(User user) {
        super.watchLater(user);
    }

    @Override
    void removeFromWatchLater(User user) {
        super.removeFromWatchLater(user);
    }

    @Override
    void alreadyWatched(User user) {
        super.alreadyWatched(user);

    }

    @Override
    void watch(String title) {
        super.watch(title);
    }



    public String toString(){
        return getTitle() + "\n" +
                getCategory() + "\n" +
                getRating() + "\n" +
                getReleaseYear() + "\n";
    }
}
