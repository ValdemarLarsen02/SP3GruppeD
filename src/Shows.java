package src;


import java.util.ArrayList;
import java.util.List;

public class Shows extends Media{
    private List<Seasons> seasons = new ArrayList<>();


    public Shows(String title, int releaseYear, ArrayList<Category> category, double rating) {
        super(title, releaseYear, category, rating);  // Brug '0' som placeholder for rating, hvis nødvendigt
    }

    public void addSeason(int seasonNumber, int episodeCount) {
        seasons.add(new Seasons(seasonNumber, episodeCount));
    }


    @Override
    void watchLater(User user, Media media) {
        super.watchLater(user, media);
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
               seasons + "\n" +
               getCategory() + "\n" +
               getRating() + "\n" +
               getReleaseYear() + "\n";
    }

}
