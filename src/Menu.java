package src;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Menu {
    private ArrayList<String> listOfActions;
    private ArrayList<String> listOfActions2;
    private ArrayList<String> optionslist;
    private Util util;
    private User user = new User();
    private Streaming streaming = new Streaming();
    private Media media;
    private SearchHandler sh = new SearchHandler();
    private String username;
    private String password;
    private Category category;



    public void ShowMenu() {

    }

    public void startMenu() {
        this.util = new Util();
        util.displayMsg("Welcome to Streaming Service!");
        listOfActions = new ArrayList<>();
        listOfActions.add("1) Login");
        listOfActions.add("2) Register");
        listOfActions.add("3) Exit");


        int action = 0;
        while (action != listOfActions.size()) {
            action = util.promptChoice(listOfActions, "");

            switch (action) {
                case 1:
                    this.username = this.usernameInfoScreen("Please enter username!");
                    this.password = this.passwordInfoScreen("Please enter password!");
                    if(user.login(this.username, this.password, "data/Users.csv")){
                        util.displayMsg("Du er nu logget ind");
                        mainMenu();
                    }
                    else{
                        util.displayMsg("Dit brugernavn eller kodeord er forkert, prøv igen");
                    }
                    break;
                case 2:
                    this.username = this.usernameInfoScreen("Please enter username!");
                    this.password = this.passwordInfoScreen("Please enter password!");
                    streaming.createAccount(this.username, this.password, "data/Users.csv" );
                    mainMenu();
                    break;
                case 3:
                    this.exit();
                    break;

            }
        }
    }


    public void exit() {
    }

    public String usernameInfoScreen(String msg) {
        String username;
        username = util.promptText(msg);
        return username;

    }

    public String passwordInfoScreen(String msg) {
        String password;
        password = util.promptText(msg);
        return password;
    }
    public void settings() {

        optionslist = new ArrayList<>();
        optionslist.add("1) Change password");
        optionslist.add("2) Exit");
        int input =  util.promptChoice(optionslist, "Make a choice!");
        if (input == 1) {
            this.username = usernameInfoScreen("Please enter username!");
            this.password = passwordInfoScreen("Please enter password!");
           // io.registerUser(username, password);
        } else if(input == 2) {
            exit();
        }
    }

    public ArrayList<Media> mainMenu() {
        this.sh = new SearchHandler();
        // instantiering af film og serier
        ArrayList<Category> categories = new ArrayList<>();
        media = new Movies("Some title", 2000, categories , 2.0);
        media = new Shows( "random", 0, categories , 5.0);


        util.displayMsg("Make a choice!");
        listOfActions2 = new ArrayList<>();
        listOfActions2.add("1) Movies");
        listOfActions2.add("2) Shows");
        listOfActions2.add("3) Genre");
        listOfActions2.add("4) Search movies");
        listOfActions2.add("5) Search shows");
        listOfActions2.add("6) Settings");
        listOfActions2.add("7) exit");

        int action1 = 0;
        while (action1 != listOfActions2.size()) {
            action1 = util.promptChoice(listOfActions2, "");

            switch (action1) {
                case 1:
                    String moviesPath = "data/film.txt"; // Erstat med den korrekte sti til dine filmdata
                    List<Media> movies = Media.loadMedia(moviesPath);
                    media.displayMediaList(movies, 0, 20);
                    int choice = util.promptNumeric("Select a movie:");
                    media.watch(String.valueOf(movies.get(choice-1)));
                    break;
                case 2:
                    String seriePath = "data/serier.txt"; // Erstat med den korrekte sti til dine filmdata
                    List<Media> shows = Media.loadMedia(seriePath);
                    media.displayMediaList(shows, 0, 20);
                    int choice1 = util.promptNumeric("Select a movie:");
                    media.watch(String.valueOf(shows.get(choice1-1)));
                    break;
                case 3:
                    ArrayList<Category> allCategories = new ArrayList<>(Arrays.asList(Category.values()));
                    String buffer = "";
                    for(Category c : allCategories){
                        buffer += c.toString()+", ";
                    }
                    util.displayMsg(buffer);
                    String input = util.promptText("Pick a category.");
                    Category searchCategory = Category.findCategory(input);
                    return new SearchHandler().genreSearch(searchCategory);

                case 4:
                    String input1 = util.promptText("Please make a search:");
                    ArrayList<Media> media1 = sh.searchInput(input1);
                    System.out.println(media1);
                    break;
                case 5:
                case 6:
                    settings();
                    break;
                case 7:
                    exit();
                    break;
            }
        }
        return null;


    }
}