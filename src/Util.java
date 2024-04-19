package src;

import java.util.Scanner;
import java.util.ArrayList;

public class Util {
    Scanner scanner = new Scanner(System.in);

    public void displayList(ArrayList<String> list, String msg){
        System.out.println(msg);
        for (String option : list) {
            System.out.println(option);
        }
    }
    String promtText(String msg) {
        displayMsg(msg);
        String input = scanner.nextLine();
        return input;
    }

    int promptChoice(String msg, ArrayList<String> list){
        displayMsg(msg);
        displayList(optionslist, "");
        int input = promptNumeric("");
        //  return optionslist.get(input-1);
        return input;
    }

    void displayMsg(String msg){
        System.out.println("\n***************");
        System.out.println(msg);
        System.out.println("***************\n");
    }


}
