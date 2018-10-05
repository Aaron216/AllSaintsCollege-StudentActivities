import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Check number of arguments
        if (args.length != 1) {
            System.out.print("Incorrect number of arguments.");
            System.exit(1);
        }

        // Declare variables
        String filename = args[1];
        HashMap<Student> students = importStudents(filename);
    }

    private static HashMap<Student> importStudents(String filename) {
        HashMap<Student> students = new HashMap<>();
        FileReader fileStrm = null;
        BufferedReader reader;
        int lineNo = 1;
        String line;
        String[] parts;

        try {
            // Init file reader
            fileStrm = new FileReader(filename);
            reader = new BufferedReader(fileStrm);
            line = reader.readLine();

            // Skip header row
            lineNo++;
            line = reader.readLine();

            // Loop through to create students
            while (line != null) {
                // Process current line
                students = updateStudents(students, line);

                // Get next line
                lineNo++;
                line = reader.readLine();
            }

            reader.close();

        }
        catch(IOException ioException1) {
            if (fileStrm != null) {
                // Close file stream
                try {
                    fileStrm.close();
                }
                catch (IOException ioException2) {
                    // No further action
                }
                System.out.println("Error reading file at line " + lineNo);
                System.out.println(ioException1.getMessage());
            }
        }

        return students;
    }

    private static updateStudents(HashMap<Student> students, String line) {
        Student currStudent = new Student();

        students.
    }
}