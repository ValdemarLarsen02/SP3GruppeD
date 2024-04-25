package src;

public class User {
    FileIO fileIO = new FileIO();

    private String username;
    private String password;

    void login(String username, String password) {
        this.username = username;
        this.password = password;
        //Tjek om username og password ligger i vores fil til at gemme userdata
    }

}
