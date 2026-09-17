import java.util.ArrayList;

public class MarksManager {

    private ArrayList<Marks> marksList;

    // Constructor
    public MarksManager() {
        marksList = new ArrayList<>();
    }

    // Add Marks
    public void addMarks(Marks marks) {
        marksList.add(marks);
        System.out.println("Marks added successfully!");
    }

    // Get all marks
    public ArrayList<Marks> getMarksList() {
        return marksList;
    }

    // View All Marks
    public void viewAllMarks() {

        if (marksList.isEmpty()) {
            System.out.println("No marks found.");
            return;
        }

        System.out.println("\n========== ALL STUDENT MARKS ==========");

        for (Marks marks : marksList) {
            marks.displayMarks();
            System.out.println("---------------------------------------");
        }
    }

    // Search Marks
    public void searchMarks(int studentId) {

        Marks marks = getMarksByStudentId(studentId);

        if (marks != null) {

            System.out.println("\nMarks found!");
            marks.displayMarks();

        } else {

            System.out.println(
                    "Marks not found for Student ID: " + studentId
            );
        }
    }

    // Get Marks of a Student
    public Marks getMarksByStudentId(int studentId) {

        for (Marks marks : marksList) {

            if (marks.getStudentId() == studentId) {
                return marks;
            }
        }

        return null;
    }
}