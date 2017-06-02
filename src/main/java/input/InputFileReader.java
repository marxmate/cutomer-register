package input;

import data.Customer;
import validation.EmailAddressValidator;
import validation.PhoneNumberValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFileReader {

    private EmailAddressValidator emailAddressValidator;
    private PhoneNumberValidator phoneNumberValidator;

    public InputFileReader() {
        this.emailAddressValidator = new EmailAddressValidator();
        this.phoneNumberValidator = new PhoneNumberValidator();
    }

    private String formatString(String s) {
        s = s.trim();
        while (s.contains("\"")) {
            s = s.replaceFirst("\"", "");
        }
        return evaluateString(s);
    }

    private String evaluateString(String s) {
        if (s.length() == 0 || s.equals(null) || s.isEmpty() || s.trim().isEmpty()) {
            s = "Empty";
        }
        return s;
    }

    protected String formatPhoneNumber(String phoneNumber) {
        if (formatString(phoneNumber).equals("Empty")) {
            phoneNumber = "Empty";
        } else if (phoneNumberValidator.validate(formatString(phoneNumber))) {
            phoneNumber = formatString(phoneNumber).replaceAll("\\D", "");
            phoneNumber = new StringBuilder()
                    .append(phoneNumber.substring(0, 4))
                    .append("/")
                    .append(phoneNumber.substring(4, 7))
                    .append("-")
                    .append(phoneNumber.substring(7,11))
                    .toString();
        } else {
            phoneNumber = "INVALID";
        }

        return phoneNumber;
    }

    protected String formatEmailAddress(String emailAddress) {
        return formatString(emailAddress).equals("Empty") ? "Empty" :
                (emailAddressValidator.validate(formatString(emailAddress)) ? formatString(emailAddress) : "INVALID");
    }

    public ArrayList<Customer> readFromFile(String fileName) throws URISyntaxException, FileNotFoundException {
        ArrayList<Customer> customerList = new ArrayList<>();
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        Scanner scanner = new Scanner(inputStream);
        scanner.nextLine(); //first line contains fields
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split("[:,]+", -1);
            Customer customer = new Customer(
                    formatString(data[0]).equals("Empty") ? "XXX" : formatString(data[0]),
                    formatPhoneNumber(data[1]),
                    formatEmailAddress(data[2]));
            customerList.add(customer);
        }
        return customerList;
    }


}
