package src;

import java.util.ArrayList;
import java.util.List;
public class Menu {
    private ArrayList<String> listOfActions;
    private ArrayList<String> listOfActions2;
    private ArrayList<String> optionslist;
    private Util util;
    private Streaming stream;
    private Media media;
    private SearchHandler sh;
    private User user;
    private FileIO io;
    private String username;
    private String password;

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
                    user.login(this.username, this.password);
                    break;
                case 2:
                    this.username = this.usernameInfoScreen("Please enter username!");
                    this.password = this.passwordInfoScreen("Please enter password!");
                    //stream.createAccount(this.username, this.password);
                    mainMenu();
                    break;
                case 3:
                    this.exit();
                    break;

            }
        }
    }


    public void exit() {
        io.saveMediaData("");
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
            io.saveUserData(username, password);
        } else if(input == 2) {
            exit();
        }
    }

    public String mainMenu() {
        // instantiering af film og serier
        media = new Movies("Some title", 2000, "Some category", 5.0);
        media = new Shows( "random", 0, "test", 5.0);
        util.displayMsg("Make a choice!");
        listOfActions2 = new ArrayList<>();
        listOfActions2.add("1) Movies");
        listOfActions2.add("2) Shows");
        listOfActions2.add("3) Genre");
        listOfActions2.add("4) Search");
        listOfActions2.add("5) Settings");
        listOfActions2.add("6) exit");

        int action1 = 0;
        while (action1 != listOfActions2.size()) {
            action1 = util.promptChoice(listOfActions2, "");

            switch (action1) {
                case 1:
                    String moviesPath = "data/film.txt"; // Erstat med den korrekte sti til dine filmdata
                    List<Media> movies = Media.loadMedia(moviesPath);
                    media.displayMediaList(movies, 0, 30);
                    break;
                case 2:
                    String seriePath = "data/serier.txt"; // Erstat med den korrekte sti til dine filmdata
                    List<Media> shows = Media.loadMedia(seriePath);
                    media.displayMediaList(shows, 0, 20);
                    break;
                case 3:
                    sh.genreSearch("");
                    break;
                case 4:
                    sh.searchInput("");
                    break;
                case 5:
                    settings();
                    break;
                case 6:
                    exit();
                    break;
            }
        }
        return null;


    }
}