package src;

import java.util.List;

public class Movies extends Media{

    public Movies(String title, int releaseYear, String category, double rating) {
        super(title, releaseYear, category, rating);
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
    void watch() {
        super.watch();
    }

    public String toString(){
        return "";
    }
}
