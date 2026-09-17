import java.io.*;

public class FileManager {

    private static final String DATA_FOLDER = "../data/";

    private static final String STUDENT_FILE =
            DATA_FOLDER + "students.txt";

    private static final String MARKS_FILE =
            DATA_FOLDER + "marks.txt";

    private static final String ATTENDANCE_FILE =
            DATA_FOLDER + "attendance.txt";


    // =========================
    // CREATE DATA FOLDER
    // =========================

    public void createDataFolder() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }


    // =========================
    // SAVE STUDENT
    // =========================

    public void saveStudent(Student student) {

        createDataFolder();

        try (FileWriter writer =
                     new FileWriter(STUDENT_FILE, true)) {

            writer.write(
                    student.getId()
                            + "|"
                            + student.getName()
                            + "|"
                            + student.getCourse()
                            + "\n"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving student data."
            );
        }
    }


    // =========================
    // LOAD STUDENTS
    // =========================

    public void loadStudents(
            StudentManager studentManager) {

        File file = new File(STUDENT_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 3) {

                    int id =
                            Integer.parseInt(data[0]);

                    String name = data[1];

                    String course = data[2];

                    Student student =
                            new Student(
                                    id,
                                    name,
                                    course
                            );

                    studentManager.getStudents()
                            .add(student);
                }
            }

            System.out.println(
                    "Student data loaded successfully!"
            );

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading student data."
            );
        }
    }


    // =========================
    // UPDATE STUDENT FILE
    // =========================

    public void updateStudentFile(
            StudentManager studentManager) {

        createDataFolder();

        try (FileWriter writer =
                     new FileWriter(STUDENT_FILE, false)) {

            for (Student student :
                    studentManager.getStudents()) {

                writer.write(
                        student.getId()
                                + "|"
                                + student.getName()
                                + "|"
                                + student.getCourse()
                                + "\n"
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error updating student file."
            );
        }
    }


    // =========================
    // SAVE MARKS
    // =========================

    public void saveMarks(Marks marks) {

        createDataFolder();

        try (FileWriter writer =
                     new FileWriter(MARKS_FILE, true)) {

            writer.write(
                    marks.getStudentId()
                            + "|"
                            + marks.getMathematics()
                            + "|"
                            + marks.getJava()
                            + "|"
                            + marks.getOperatingSystems()
                            + "\n"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving marks data."
            );
        }
    }


    // =========================
    // LOAD MARKS
    // =========================

    public void loadMarks(
            MarksManager marksManager) {

        File file = new File(MARKS_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    int studentId =
                            Integer.parseInt(data[0]);

                    double mathematics =
                            Double.parseDouble(data[1]);

                    double java =
                            Double.parseDouble(data[2]);

                    double operatingSystems =
                            Double.parseDouble(data[3]);

                    Marks marks =
                            new Marks(
                                    studentId,
                                    mathematics,
                                    java,
                                    operatingSystems
                            );

                    marksManager.getMarksList()
                            .add(marks);
                }
            }

            System.out.println(
                    "Marks data loaded successfully!"
            );

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading marks data."
            );
        }
    }


    // =========================
    // SAVE ATTENDANCE
    // =========================

    public void saveAttendance(
            Attendance attendance) {

        createDataFolder();

        try (FileWriter writer =
                     new FileWriter(
                             ATTENDANCE_FILE,
                             true)) {

            writer.write(
                    attendance.getStudentId()
                            + "|"
                            + attendance.getTotalClasses()
                            + "|"
                            + attendance.getAttendedClasses()
                            + "\n"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving attendance data."
            );
        }
    }


    // =========================
    // LOAD ATTENDANCE
    // =========================

    public void loadAttendance(
            AttendanceManager attendanceManager) {

        File file =
                new File(ATTENDANCE_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 3) {

                    int studentId =
                            Integer.parseInt(data[0]);

                    int totalClasses =
                            Integer.parseInt(data[1]);

                    int attendedClasses =
                            Integer.parseInt(data[2]);

                    Attendance attendance =
                            new Attendance(
                                    studentId,
                                    totalClasses,
                                    attendedClasses
                            );

                    attendanceManager
                            .getAttendanceList()
                            .add(attendance);
                }
            }

            System.out.println(
                    "Attendance data loaded successfully!"
            );

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading attendance data."
            );
        }
    }
}
