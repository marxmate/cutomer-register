package input;

import data.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInputReader extends InputFileReader {

    public Customer addFromConsole(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Phone: ");
        String phone = scanner.next();
        phone = formatPhoneNumber(phone);
        System.out.print("Email: ");
        String email = scanner.next();
        email = formatEmailAddress(email);
        return new Customer(name, phone, email);
    }

    private int findCustomer(Scanner scanner, ArrayList<Customer> customers) {
        System.out.print("Finding an existing customer. Please give me the name of the customer! \nName: ");
        String name = scanner.next();
        int i = 0;
        while (i<customers.size() && !customers.get(i).getName().equals(name)) {
            i++;
        }
        return i;
    }

    public ArrayList<Customer> deleteCustomer(ArrayList<Customer> customers, Scanner scanner) {
        int index = findCustomer(scanner, customers);
        if (index == customers.size()) {
            System.out.println("This name doesn't exists in the list.");
        } else {
            doDelete(index, customers, scanner);
        }
        return customers;
    }


    public ArrayList<Customer> updateFromConsole(ArrayList<Customer> customers, Scanner scanner) {
        int index = findCustomer(scanner, customers);
        if (index == customers.size()) {
            System.out.println("This name doesn't exists in the list.");
        } else {
            doUpdate(index, customers, scanner);
        }
        return customers;
    }

    private void doUpdate(int index, ArrayList<Customer> customers, Scanner scanner) {
        Customer customer = addFromConsole(scanner);
        customers.set(index, customer);
    }

    private void doDelete(int index, ArrayList<Customer> customers, Scanner scanner) {
        Customer customer = customers.remove(index);
        System.out.println("You deleted the following customer:");
        System.out.println(customer.toString());
    }


}
