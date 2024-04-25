package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {
    private String loggedInUsername;

    public boolean login(String username, String password, String path) {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("data/Users.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(csvSplitBy);
                if (userData.length >= 0 && userData[0].equals(username) && userData[1].equals(password)) {
                    loggedInUsername = username;
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data: " + e.getMessage());
        }
        return false;
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }
}


