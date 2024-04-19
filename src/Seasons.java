package src;

public class Seasons extends Media {

    public Seasons(String title, int releaseYear, String category, double rating) {
        super(title, releaseYear, category, rating);
    }

    @Override
    void alreadyWatched(User user) {
        super.alreadyWatched(user);
    }

    @Override
    void watch() {
        super.watch();
    }
}
