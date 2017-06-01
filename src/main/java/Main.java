import input.Action;
import input.InputFileReader;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    private static InputFileReader inputFileReader = new InputFileReader();

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        inputFileReader.readFromFile("/textfiles/input.txt");
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        while (!userInput.equals("exit")) {
            System.out.println("What would you like to do? (EXIT, UPDATE, ADD, DELETE)  ");
            userInput = scanner.next();
            try{
                Action act = new Action(Action.Actions.valueOf(userInput.toUpperCase()));
                act.executeAction();
                //TODO: befejezni.
                //TODO: https://stackoverflow.com/questions/17481016/how-to-convert-string-value-into-enum-in-java
            } catch (IllegalArgumentException e) {
                System.out.println("Sorry, this is not a valid action. Please give me a valid one! (EXIT, UPDATE, ADD, DELETE)  ");
            }
        }
    }
}
