public class StudentTest {

    public static void main(String[] args) {

        // Create a student
        Student student =
                new Student(
                        101,
                        "Aditya",
                        "Computer Science"
                );

        // Test Student ID
        if (student.getId() == 101) {
            System.out.println("PASS: Student ID");
        } else {
            System.out.println("FAIL: Student ID");
        }

        // Test Student Name
        if (student.getName().equals("Aditya")) {
            System.out.println("PASS: Student Name");
        } else {
            System.out.println("FAIL: Student Name");
        }

        // Test Student Course
        if (student.getCourse().equals("Computer Science")) {
            System.out.println("PASS: Student Course");
        } else {
            System.out.println("FAIL: Student Course");
        }

        // Test Student Manager
        StudentManager manager =
                new StudentManager();

        manager.addStudent(student);

        if (manager.studentExists(101)) {
            System.out.println("PASS: Student Manager");
        } else {
            System.out.println("FAIL: Student Manager");
        }

        System.out.println("\nAll basic tests completed.");
    }
}
