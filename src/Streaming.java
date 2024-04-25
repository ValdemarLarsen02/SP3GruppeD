package src;

import java.util.ArrayList;


public class Streaming {
    private ArrayList<String> listOfActions;
    private FileIO io = new FileIO();
    private Util util;
    private Menu menu;

    String username;
    String password;

    /*public Streaming() {

        this.io = new FileIO();
        this.util = new Util();
        this.menu = new Menu();
        menu.startMenu();


    }*/


    void createAccount(String username, String password, String path) {
        this.username = username;
        this.password = password;
        io.saveUserData(username, password, path);
    }
}
