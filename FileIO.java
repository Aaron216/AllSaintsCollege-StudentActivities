import java.io.*;
import java.util.LinkedList;

public class FileIO {
    public static LinkedList<String> readFile(String filename) {
        LinkedList<String> inputStrings = new LinkedList<>();
        FileReader fileStrm = null;
        BufferedReader reader;
        int lineNo = 1;
        String line;

        try {
            // Init file reader
            fileStrm = new FileReader(filename);
            reader = new BufferedReader(fileStrm);
            line = reader.readLine();

            // Skip header row
            lineNo++;
            line = reader.readLine();

            // Loop through to read every line
            while (line != null) {
                // Add current line to linked list
                inputStrings.add(line);

                // Get next line
                lineNo++;
                line = reader.readLine();
            }
        }
        catch (Exception ex) {
            System.out.println("Error reading file at line " + lineNo);
            System.out.println(ex.getMessage());
        }
        finally {
            if (fileStrm != null) {
                // Close file stream
                try {
                    fileStrm.close();
                }
                catch (IOException ex) {
                    System.out.println("Error closing file");
                    System.out.println(ex.getMessage());
                }
            }
        }

        return inputStrings;
    }

    public static void writeFile(LinkedList<String> outputStrings, String filename) {
        // Check file name
        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }

        // Init file write
        FileWriter fileWrtr = null;
        BufferedWriter out;

        try {
            fileWrtr = new FileWriter(filename, false);
            out = new BufferedWriter(fileWrtr);

            // Iterate through strings
            for (String currString : outputStrings) {
                out.write(currString);
                out.newLine();
            }

            // Close
            out.close();
        }
        catch (Exception ex) {
            System.out .println("Error writing to file.");
            System.out.println(ex.getMessage());
        }
        finally {
            if (fileWrtr != null) {
                try {
                    // Close file
                    fileWrtr.close();
                }
                catch (IOException ex) {
                    System.out .println("Error closing file.");
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}