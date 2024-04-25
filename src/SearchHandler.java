package src;



import org.w3c.dom.stylesheets.MediaList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchHandler {
    private String input;
    private Media media;
    private Menu menu;

    public ArrayList<Media> searchInput(String input){
        ArrayList<Media> result = new ArrayList<>();
        String moviesPath = "data/film.txt";
        List<Media> movies = Media.loadMedia(moviesPath);
        for (Media m : movies) {
            if (m.title.matches(input)) {
                result.add(m);
            }

        }
    return result;
    }



    public ArrayList<Media> genreSearch(Category c){
        ArrayList<Media> returnMedia = new ArrayList<>();
        String moviesPath = "data/film.txt";
        List<Media> movies = Media.loadMedia(moviesPath);
        for(Media m : movies)
            for (Category category : m.categories) {
                if (category == c) {

                    returnMedia.add(m);
                }
            }

        return returnMedia;

    }
}