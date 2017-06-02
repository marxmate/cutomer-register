import data.Customer;
import input.Action;
import input.ConsoleInputReader;
import input.InputFileReader;
import output.OutputFileWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static InputFileReader inputFileReader = new InputFileReader();
    private static OutputFileWriter outputFileWriter = new OutputFileWriter();
    private static ConsoleInputReader consoleInputReader = new ConsoleInputReader();
    private static Action action;
    private static String inputFilePath = "/input.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, URISyntaxException {
        ArrayList<Customer> customers = inputFileReader.readFromFile(inputFilePath);
        String userInput = "";
        while (!userInput.equals("EXIT")) {
            System.out.println("What would you like to do? (EXIT, UPDATE, ADD, DELETE)  ");
            userInput = scanner.next();
            try {
                action = Action.valueOf(userInput.toUpperCase());
                executeAction(customers);
            } catch (IllegalArgumentException e) {
                System.out.println("The given action does not exists!");
                continue;
            }
        }
    }

    public static void executeAction(ArrayList<Customer> customers) throws URISyntaxException, IOException {
        switch (action) {
            case ADD:
                customers.add(consoleInputReader.addFromConsole(scanner));
                break;
            case EXIT:
                endApp(customers);
                break;
            case DELETE:
                consoleInputReader.deleteCustomer(customers, scanner);
                break;
            case UPDATE:
                consoleInputReader.updateFromConsole(customers, scanner);
                break;
            default:
                System.out.println("Please give me a valid action! (EXIT, UPDATE, ADD, DELETE): ");
                break;
        }
    }

    public static void endApp(ArrayList<Customer> customers) throws URISyntaxException, IOException {
        for (Customer c : customers) {
            System.out.println(c);
        }
        System.out.println("--------------- Exit app. ---------------");
        outputFileWriter.writeToFile(customers);
        System.exit(0);
    }
}
