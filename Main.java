import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Check number of arguments
        if (args.length != 1) {
            System.out.print("Incorrect number of arguments.");
            System.exit(1);
        }

        HashMap<String, Student> students = importStudents(args[0]);
    }

    private static HashMap<String, Student> importStudents(String filename) {
        HashMap<String, Student> students = new HashMap<>();
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
    
    private static HashMap<String, Student> updateStudents(HashMap<String, Student> students, String line) {
        Student currStudent;
        String[] parts = line.split(",");
        String fullname;

        // Trim whitespace from all parts
        for (int ii = 0; ii < parts.length; ii++) {
            parts[ii] = parts[ii].trim();
        }

        fullname = parts[0] + " " + parts[1];
        currStudent = students.get(fullname);

        // Check if student already exists
        if (currStudent == null) {
            currStudent = new Student();
            currStudent.setFirstname(parts[0]);
            currStudent.setSurname(parts[1]);
        }

        // Update Students
        currStudent.addDetail(parts[2]);
        students.put(fullname, currStudent);

        return students;
    }
}