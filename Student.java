import java.util.LinkedList;

public class Student {
    // Declare Fields
    private String firstname;
    private String surname;
    private LinkedList<String> details;

    // Constructor
    public Student(){
        firstname = "";
        surname = "";
        detials = new LinkedList<String>();
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
            details.add(in);
        }
    }

    // Accessors
    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public LinkedList<String> getDetails() {
        return details;
    }

    public String toCSVRow() {
        String row = "";

        row += firstname + ",";
        row += surname + ",";
        for (String detail : details) {
            row += detail + ",";
        }

        return row;
    }
}