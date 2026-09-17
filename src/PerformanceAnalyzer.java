public class PerformanceAnalyzer {

    private MarksManager marksManager;
    private AttendanceManager attendanceManager;

    // Constructor
    public PerformanceAnalyzer(
            MarksManager marksManager,
            AttendanceManager attendanceManager) {

        this.marksManager = marksManager;
        this.attendanceManager = attendanceManager;
    }

    // Analyze Performance
    public void analyzePerformance(int studentId) {

        Marks marks =
                marksManager.getMarksByStudentId(studentId);

        Attendance attendance =
                attendanceManager.getAttendanceByStudentId(studentId);

        // Check if marks exist
        if (marks == null) {

            System.out.println(
                    "No marks found for Student ID: " + studentId
            );

            return;
        }

        // Check if attendance exists
        if (attendance == null) {

            System.out.println(
                    "No attendance found for Student ID: "
                            + studentId
            );

            return;
        }

        // Automatically calculate values
        double marksPercentage =
                marks.calculatePercentage();

        double attendancePercentage =
                attendance.calculatePercentage();

        System.out.println(
                "\n========== PERFORMANCE ANALYSIS =========="
        );

        System.out.println(
                "Student ID       : " + studentId
        );

        System.out.println(
                "Marks Percentage : "
                        + marksPercentage + "%"
        );

        System.out.println(
                "Attendance       : "
                        + attendancePercentage + "%"
        );

        String performance;

        // Determine overall performance
        if (marksPercentage >= 80
                && attendancePercentage >= 75) {

            performance = "Excellent";

        } else if (marksPercentage >= 60
                && attendancePercentage >= 75) {

            performance = "Good";

        } else if (marksPercentage >= 50
                && attendancePercentage >= 60) {

            performance = "Average";

        } else {

            performance = "Needs Improvement";
        }

        System.out.println(
                "Overall Performance : " + performance
        );

        // Attendance warning
        if (attendancePercentage < 75) {

            System.out.println(
                    "Warning: Attendance is below 75%."
            );
        }

        // Marks warning
        if (marksPercentage < 50) {

            System.out.println(
                    "Warning: Marks are below 50%."
            );
        }

        System.out.println(
                "=========================================="
        );
    }
}