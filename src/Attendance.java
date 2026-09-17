public class Attendance {

    private int studentId;
    private int totalClasses;
    private int attendedClasses;

    // Constructor
    public Attendance(int studentId, int totalClasses, int attendedClasses) {
        this.studentId = studentId;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    // Get Student ID
    public int getStudentId() {
        return studentId;
    }

    // Get Total Classes
    public int getTotalClasses() {
        return totalClasses;
    }

    // Get Attended Classes
    public int getAttendedClasses() {
        return attendedClasses;
    }

    // Calculate Attendance Percentage
    public double calculatePercentage() {

        if (totalClasses == 0) {
            return 0;
        }

        return ((double) attendedClasses / totalClasses) * 100;
    }

    // Check Attendance Status
    public String getStatus() {

        if (calculatePercentage() >= 75) {
            return "Eligible";
        } else {
            return "Not Eligible";
        }
    }

    // Display Attendance
    public void displayAttendance() {

        System.out.println("\n========== ATTENDANCE ==========");
        System.out.println("Student ID       : " + studentId);
        System.out.println("Total Classes    : " + totalClasses);
        System.out.println("Attended Classes : " + attendedClasses);
        System.out.println(
                "Attendance       : " + calculatePercentage() + "%"
        );
        System.out.println("Status           : " + getStatus());
        System.out.println("===============================");
    }
}