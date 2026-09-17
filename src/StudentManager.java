import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add Student
    public void addStudent(Student student) {

        for (Student existingStudent : students) {

            if (existingStudent.getId() == student.getId()) {

                System.out.println("Student ID already exists!");

                return;
            }
        }

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Get all students
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Check whether student exists
    public boolean studentExists(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return true;
            }
        }

        return false;
    }

    // View Students
    public void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found.");

            return;
        }

        System.out.println("\n========== STUDENT LIST ==========");

        for (Student student : students) {

            student.displayStudent();

            System.out.println("----------------------------------");
        }
    }

    // Search Student
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("\nStudent found!");

                student.displayStudent();

                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update Student
    public void updateStudent(
            int id,
            String newName,
            String newCourse) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(newName);
                student.setCourse(newCourse);

                System.out.println(
                        "Student updated successfully!"
                );

                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent(int id) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println(
                        "Student deleted successfully!"
                );

                return;
            }
        }

        System.out.println("Student not found.");
    }
}