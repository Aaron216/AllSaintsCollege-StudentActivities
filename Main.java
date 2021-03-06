/**
 * All Saints' College
 * Student Activities
 * Aaron Musgrave
 * 15/10/2018
 * 
 * Main Class
 * Responsible for processing input file
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Check number of arguments
        if (args.length != 2) {
            System.out.println("Incorrect number of arguments.");
            System.out.println(" 1. Input file");
            System.out.println(" 2. Output file");
            System.exit(1);
        }

        try {
            // Read input file
            LinkedList<String> inputStrings = FileIO.readFile(args[0]);
            HashMap<String, Student> students = processInput(inputStrings);

            // Write output file
            LinkedList<String> outputStrings = getOutput(students);
            FileIO.writeFile(outputStrings, args[1]);
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
    }

    public static HashMap<String, Student> processInput(LinkedList<String> inputStrings) {
        HashMap<String, Student> students = new HashMap<>();
        Student currStudent;
        String[] parts;
        String fullname;

        for (String currString : inputStrings) {
            // Split string
            parts = currString.split(",");

            // Trim whitespace from all parts
            for (int ii = 0; ii < parts.length; ii++) {
                parts[ii] = parts[ii].trim();
            }

            fullname = parts[0] + " " + parts[1];
            currStudent = students.get(fullname);

            // Check if student does not already exist
            if (currStudent == null) {
                currStudent = new Student();
                currStudent.setFirstname(parts[0]);
                currStudent.setSurname(parts[1]);
            }

            // Update Students
            currStudent.addDetail(parts[2]);
            students.put(fullname, currStudent);
        }

        return students;
    }

    public static LinkedList<String> getOutput(HashMap<String, Student> students) {
        LinkedList<String> outputStrings = new LinkedList<>();
        LinkedList<String> keySet = new LinkedList<>(students.keySet());
        Student currStudent;

        // Sort students by name
        Collections.sort(keySet);

        // Add Headers
        outputStrings.add("\"Firstname\",\"Surname\",\"Details\"");

        // Iterate through students
        for (String currKey : keySet) {
            currStudent = students.get(currKey);
            outputStrings.add(currStudent.toCSVRow());
        }

        return outputStrings;
    }
}