import java.util.ArrayList;

public class AttendanceManager {

    private ArrayList<Attendance> attendanceList;

    // Constructor
    public AttendanceManager() {
        attendanceList = new ArrayList<>();
    }

    // Add Attendance
    public void addAttendance(Attendance attendance) {

        attendanceList.add(attendance);

        System.out.println("Attendance added successfully!");
    }

    // Get all attendance records
    public ArrayList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    // View All Attendance
    public void viewAllAttendance() {

        if (attendanceList.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }

        System.out.println(
                "\n========== ALL ATTENDANCE RECORDS =========="
        );

        for (Attendance attendance : attendanceList) {

            attendance.displayAttendance();

            System.out.println("--------------------------------------------");
        }
    }

    // Search Attendance
    public void searchAttendance(int studentId) {

        Attendance attendance =
                getAttendanceByStudentId(studentId);

        if (attendance != null) {

            System.out.println("\nAttendance record found!");

            attendance.displayAttendance();

        } else {

            System.out.println(
                    "Attendance not found for Student ID: "
                            + studentId
            );
        }
    }

    // Get Attendance of a Student
    public Attendance getAttendanceByStudentId(int studentId) {

        for (Attendance attendance : attendanceList) {

            if (attendance.getStudentId() == studentId) {
                return attendance;
            }
        }

        return null;
    }
}