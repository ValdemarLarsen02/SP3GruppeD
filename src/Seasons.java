package src;


public class Seasons {

    private int seasonNumber;
    private int episodeCount;
    public Seasons(int seasonNumber, int episodeCount) {
        this.seasonNumber = seasonNumber;
        this.episodeCount = episodeCount;
    }

    // skal jeg måske bruge til at hente udvalgte episoder og seasons.
    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }
}
