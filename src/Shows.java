package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Shows extends Media{

    List<Seasons> seasons = new ArrayList<>();


    public Shows(String title, int releaseYear, String category, double rating) {
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
       return getTitle() + "\n" +
               seasons + "\n" +
               getCategory() + "\n" +
               getRating() + "\n" +
               getReleaseYear() + "\n";
    }

}
