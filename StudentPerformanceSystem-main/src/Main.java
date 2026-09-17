import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager studentManager = new StudentManager();
        MarksManager marksManager = new MarksManager();
        AttendanceManager attendanceManager = new AttendanceManager();

        PerformanceAnalyzer performanceAnalyzer =
                new PerformanceAnalyzer(
                        marksManager,
                        attendanceManager
                );

        ReportGenerator reportGenerator =
                new ReportGenerator(
                        studentManager,
                        marksManager,
                        attendanceManager
                );

        FileManager fileManager = new FileManager();

        // Load saved data when program starts
        fileManager.loadStudents(studentManager);
        fileManager.loadMarks(marksManager);
        fileManager.loadAttendance(attendanceManager);

        int choice = 0;

        do {

            System.out.println("\n==========================================");
            System.out.println("   STUDENT PERFORMANCE MANAGEMENT SYSTEM");
            System.out.println("==========================================");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");

            System.out.println("6. Add Marks");
            System.out.println("7. View Marks");
            System.out.println("8. Search Marks");

            System.out.println("9. Add Attendance");
            System.out.println("10. View Attendance");
            System.out.println("11. Search Attendance");

            System.out.println("12. Analyze Performance");
            System.out.println("13. Generate Student Report");
            System.out.println("14. Exit");

            System.out.print("\nEnter your choice: ");

            // Safe menu input
            if (!scanner.hasNextInt()) {

                System.out.println(
                        "Invalid input! Please enter a number."
                );

                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // =========================
                // 1. ADD STUDENT
                // =========================
                case 1:

                    System.out.print("Enter Student ID: ");

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (!InputValidator.isValidStudentId(id)) {

                        System.out.println(
                                "Invalid Student ID!"
                        );

                        break;
                    }

                    System.out.print("Enter Student Name: ");

                    String name = scanner.nextLine();

                    if (!InputValidator.isValidName(name)) {

                        System.out.println(
                                "Invalid Student Name!"
                        );

                        break;
                    }

                    System.out.print("Enter Course: ");

                    String course = scanner.nextLine();

                    if (!InputValidator.isValidCourse(course)) {

                        System.out.println(
                                "Invalid Course!"
                        );

                        break;
                    }

                    Student student =
                            new Student(
                                    id,
                                    name,
                                    course
                            );

                    studentManager.addStudent(student);

                    fileManager.saveStudent(student);

                    break;


                // =========================
                // 2. VIEW STUDENTS
                // =========================
                case 2:

                    studentManager.viewStudents();

                    break;


                // =========================
                // 3. SEARCH STUDENT
                // =========================
                case 3:

                    System.out.print(
                            "Enter Student ID to search: "
                    );

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int searchId = scanner.nextInt();

                    studentManager.searchStudent(searchId);

                    break;


                // =========================
                // 4. UPDATE STUDENT
                // =========================
                case 4:

                    System.out.print(
                            "Enter Student ID to update: "
                    );

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    if (!studentManager.studentExists(updateId)) {

                        System.out.println(
                                "Student not found."
                        );

                        break;
                    }

                    System.out.print("Enter new name: ");

                    String newName = scanner.nextLine();

                    if (!InputValidator.isValidName(newName)) {

                        System.out.println(
                                "Invalid Student Name!"
                        );

                        break;
                    }

                    System.out.print("Enter new course: ");

                    String newCourse = scanner.nextLine();

                    if (!InputValidator.isValidCourse(newCourse)) {

                        System.out.println(
                                "Invalid Course!"
                        );

                        break;
                    }

                    studentManager.updateStudent(
                            updateId,
                            newName,
                            newCourse
                    );

                    fileManager.updateStudentFile(
                            studentManager
                    );

                    break;


                // =========================
                // 5. DELETE STUDENT
                // =========================
                case 5:

                    System.out.print(
                            "Enter Student ID to delete: "
                    );

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int deleteId = scanner.nextInt();

                    if (!studentManager.studentExists(deleteId)) {

                        System.out.println(
                                "Student not found."
                        );

                        break;
                    }

                    studentManager.deleteStudent(deleteId);

                    fileManager.updateStudentFile(
                            studentManager
                    );

                    break;


                // =========================
                // 6. ADD MARKS
                // =========================
                case 6:

                    System.out.println(
                            "\n========== ADD MARKS =========="
                    );

                    System.out.print("Enter Student ID: ");

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int marksStudentId = scanner.nextInt();

                    if (!studentManager.studentExists(
                            marksStudentId)) {

                        System.out.println(
                                "Student does not exist!"
                        );

                        break;
                    }

                    System.out.print(
                            "Enter Mathematics Marks: "
                    );

                    if (!scanner.hasNextDouble()) {

                        System.out.println(
                                "Invalid marks! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    double mathematics = scanner.nextDouble();

                    if (!InputValidator.isValidMarks(mathematics)) {

                        System.out.println(
                                "Marks must be between 0 and 100!"
                        );

                        break;
                    }

                    System.out.print("Enter Java Marks: ");

                    if (!scanner.hasNextDouble()) {

                        System.out.println(
                                "Invalid marks! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    double java = scanner.nextDouble();

                    if (!InputValidator.isValidMarks(java)) {

                        System.out.println(
                                "Marks must be between 0 and 100!"
                        );

                        break;
                    }

                    System.out.print(
                            "Enter Operating Systems Marks: "
                    );

                    if (!scanner.hasNextDouble()) {

                        System.out.println(
                                "Invalid marks! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    double operatingSystems =
                            scanner.nextDouble();

                    if (!InputValidator.isValidMarks(
                            operatingSystems)) {

                        System.out.println(
                                "Marks must be between 0 and 100!"
                        );

                        break;
                    }

                    Marks marks =
                            new Marks(
                                    marksStudentId,
                                    mathematics,
                                    java,
                                    operatingSystems
                            );

                    marksManager.addMarks(marks);

                    fileManager.saveMarks(marks);

                    break;


                // =========================
                // 7. VIEW MARKS
                // =========================
                case 7:

                    marksManager.viewAllMarks();

                    break;


                // =========================
                // 8. SEARCH MARKS
                // =========================
                case 8:

                    System.out.print(
                            "Enter Student ID to search marks: "
                    );

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int marksSearchId = scanner.nextInt();

                    marksManager.searchMarks(
                            marksSearchId
                    );

                    break;


                // =========================
                // 9. ADD ATTENDANCE
                // =========================
                case 9:

                    System.out.println(
                            "\n======= ADD ATTENDANCE ======="
                    );

                    System.out.print("Enter Student ID: ");

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int attendanceStudentId =
                            scanner.nextInt();

                    if (!studentManager.studentExists(
                            attendanceStudentId)) {

                        System.out.println(
                                "Student does not exist!"
                        );

                        break;
                    }

                    System.out.print(
                            "Enter Total Classes: "
                    );

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid number! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int totalClasses = scanner.nextInt();

                    if (!InputValidator.isValidTotalClasses(
                            totalClasses)) {

                        System.out.println(
                                "Total classes must be greater than 0!"
                        );

                        break;
                    }

                    System.out.print(
                            "Enter Attended Classes: "
                    );

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid number! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int attendedClasses = scanner.nextInt();

                    if (!InputValidator.isValidAttendedClasses(
                            totalClasses,
                            attendedClasses)) {

                        System.out.println(
                                "Attended classes cannot be greater than total classes!"
                        );

                        break;
                    }

                    Attendance attendance =
                            new Attendance(
                                    attendanceStudentId,
                                    totalClasses,
                                    attendedClasses
                            );

                    attendanceManager.addAttendance(
                            attendance
                    );

                    fileManager.saveAttendance(
                            attendance
                    );

                    break;


                // =========================
                // 10. VIEW ATTENDANCE
                // =========================
                case 10:

                    attendanceManager.viewAllAttendance();

                    break;


                // =========================
                // 11. SEARCH ATTENDANCE
                // =========================
                case 11:

                    System.out.print(
                            "Enter Student ID to search attendance: "
                    );

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int attendanceSearchId =
                            scanner.nextInt();

                    attendanceManager.searchAttendance(
                            attendanceSearchId
                    );

                    break;


                // =========================
                // 12. ANALYZE PERFORMANCE
                // =========================
                case 12:

                    System.out.println(
                            "\n====== ANALYZE PERFORMANCE ======"
                    );

                    System.out.print("Enter Student ID: ");

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int performanceId = scanner.nextInt();

                    performanceAnalyzer.analyzePerformance(
                            performanceId
                    );

                    break;


                // =========================
                // 13. GENERATE REPORT
                // =========================
                case 13:

                    System.out.println(
                            "\n====== GENERATE STUDENT REPORT ======"
                    );

                    System.out.print(
                            "Enter Student ID: "
                    );

                    if (!scanner.hasNextInt()) {

                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );

                        scanner.nextLine();
                        break;
                    }

                    int reportId = scanner.nextInt();

                    reportGenerator.generateReport(
                            reportId
                    );

                    break;


                // =========================
                // 14. EXIT
                // =========================
                case 14:

                    System.out.println(
                            "\nThank you for using the system!"
                    );

                    break;


                // =========================
                // INVALID CHOICE
                // =========================
                default:

                    System.out.println(
                            "\nInvalid choice! Please try again."
                    );
            }

        } while (choice != 14);

        scanner.close();
    }
}