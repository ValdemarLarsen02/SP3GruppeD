package src;

import java.util.Scanner;
import java.util.ArrayList;

public class Util {
    Scanner scanner = new Scanner(System.in);

    public void displayList(ArrayList<String> list, String msg) {
        System.out.println(msg);
        for (String option : list) {
            System.out.println(option);
        }
    }

    String promptText(String msg) {
        displayMsg(msg);
        String input = scanner.nextLine();
        return input;
    }

    public int promptNumeric(String msg) {
        String input = promptText(msg);         //Give brugere et sted at placere sit svar og vente pÃ¥ svaret
        int number = Integer.parseInt(input);       //Konvertere svaret til et tal
        return number;
    }


    void displayMsg(String msg) {
        System.out.println(msg);
    }

    public int promptChoice(ArrayList<String> optionslist, String msg) {
        displayList(optionslist, "");
        int input = promptNumeric("");//1
        //  return optionslist.get(input-1);
        return input;

    }
}
