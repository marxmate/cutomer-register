package output;

import data.Customer;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class OutputFileWriter {
    public void writeToFile(ArrayList<Customer> customers) throws URISyntaxException, IOException {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        f.showSaveDialog(null);

        final File output = f.getSelectedFile();
        if(!output.exists() || output.isDirectory()) {
            output.createNewFile();
        }
        try {
            FileWriter fw = new FileWriter(output, false);
            for (Customer c : customers) {
                fw.write(c.toString());
                fw.write(System.getProperty( "line.separator" ));
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
