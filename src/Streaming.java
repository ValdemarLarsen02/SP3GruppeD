package src;

import java.util.ArrayList;


public class Streaming {
    private ArrayList<String> listOfActions;
    private FileIO io;
    private Util util;
    private Menu menu;

    String username;
    String password;

    public Streaming() {

        this.io = new FileIO();
        this.util = new Util();
        this.menu = new Menu();
        menu.startMenu();



    }
    void createAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
