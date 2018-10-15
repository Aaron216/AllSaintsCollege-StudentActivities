import java.util.LinkedList;
import java.util.Collections;

public class Student {
    // Declare Fields
    private String firstname;
    private String surname;
    private LinkedList<String> detailList;

    // Constructor
    public Student(){
        firstname = "";
        surname = "";
        detailList = new LinkedList<String>();
    }

    // Mutators
    public void setFirstname(String in) {
        if (in.isEmpty()) {
            throw new IllegalArgumentException("Firstname cannot by null");
        }
        else {
            firstname = in;
        }
    }

    public void setSurname(String in) {
        if (in.isEmpty()) {
            throw new IllegalArgumentException("Surname cannot by null");
        }
        else {
            surname = in;
        }
    }

    public void addDetail(String in) {
        if (in.isEmpty()) {
            throw new IllegalArgumentException("Detail cannot be null");
        }
        else {
            detailList.add(in);
        }
    }

    // Accessors
    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullname() {
        return (firstname + " " + surname);
    }

    public LinkedList<String> getDetails() {
        return detailList;
    }

    public String toCSVRow() {
        // Sort Details
        Collections.sort(detailList);

        String row = "";
        row += firstname + ",";
        row += surname + ",";
        for (String detail : detailList) {
            row += detail + ",";
        }

        return row;
    }
}