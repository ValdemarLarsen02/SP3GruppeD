package src;

public class User {

    private String username;
    private String password;

    void login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    void createAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
