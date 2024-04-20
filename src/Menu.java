package src;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> listOfActions;
    private ArrayList<String> listOfActionss;
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
                    this.username = this.usernameInfoScreen();
                    this.password = this.passwordInfoScreen();
                    user.login(this.username, this.password);
                    mainMenu();
                    break;
                case 2:
                    this.username = this.usernameInfoScreen();
                    this.password = this.passwordInfoScreen();
                    stream.createAccount(this.username, this.password);
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

    public String usernameInfoScreen() {
        String username;
        username = util.promptText("Please enter username!");
        return username;

    }

    public String passwordInfoScreen() {
        String password;
        password = util.promptText("Please enter password!");
        return password;
    }
    public void settings() {
        //util.promptChoice()
    }

    public String mainMenu() {
        util.displayMsg("Make a choice!");
        listOfActionss = new ArrayList<>();
        listOfActionss.add("1) Movies");
        listOfActionss.add("2) Shows");
        listOfActionss.add("3) Genre");
        listOfActionss.add("4) Search");
        listOfActionss.add("5) Settings");
        listOfActionss.add("4) exit");

        int action1 = 0;
        while (action1 != listOfActionss.size()) {
            action1 = util.promptChoice(listOfActionss, "");

            switch (action1) {
                case 1:
                    //media.watch(1);
                    break;
                case 2:
                    //media.watch(2);
                    break;
                case 3:
                    sh.genreSearch("");
                    break;
                case 4:
                    sh.searchInput("");
                    break;
                case 5:



            }
        }
        return null;


    }
}