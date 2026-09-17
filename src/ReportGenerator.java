public class ReportGenerator {

    private StudentManager studentManager;
    private MarksManager marksManager;
    private AttendanceManager attendanceManager;

    public ReportGenerator(
            StudentManager studentManager,
            MarksManager marksManager,
            AttendanceManager attendanceManager) {

        this.studentManager = studentManager;
        this.marksManager = marksManager;
        this.attendanceManager = attendanceManager;
    }

    public void generateReport(int studentId) {

        Student student = null;

        for (Student s : studentManager.getStudents()) {

            if (s.getId() == studentId) {
                student = s;
                break;
            }
        }

        if (student == null) {

            System.out.println("Student not found.");

            return;
        }

        Marks marks =
                marksManager.getMarksByStudentId(studentId);

        Attendance attendance =
                attendanceManager.getAttendanceByStudentId(studentId);

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "       STUDENT PERFORMANCE REPORT"
        );

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "\n---------- STUDENT DETAILS ----------"
        );

        System.out.println(
                "Student ID : " + student.getId()
        );

        System.out.println(
                "Name       : " + student.getName()
        );

        System.out.println(
                "Course     : " + student.getCourse()
        );

        if (marks != null) {

            System.out.println(
                    "\n---------- ACADEMIC PERFORMANCE ----------"
            );

            System.out.println(
                    "Mathematics       : "
                            + marks.getMathematics()
            );

            System.out.println(
                    "Java              : "
                            + marks.getJava()
            );

            System.out.println(
                    "Operating Systems : "
                            + marks.getOperatingSystems()
            );

            System.out.println(
                    "Total Marks       : "
                            + marks.calculateTotal()
            );

            System.out.println(
                    "Percentage        : "
                            + marks.calculatePercentage()
                            + "%"
            );

            System.out.println(
                    "Grade             : "
                            + marks.calculateGrade()
            );

        } else {

            System.out.println(
                    "\nNo marks record found."
            );
        }

        if (attendance != null) {

            System.out.println(
                    "\n---------- ATTENDANCE ----------"
            );

            System.out.println(
                    "Total Classes    : "
                            + attendance.getTotalClasses()
            );

            System.out.println(
                    "Attended Classes : "
                            + attendance.getAttendedClasses()
            );

            System.out.println(
                    "Attendance       : "
                            + attendance.calculatePercentage()
                            + "%"
            );

            System.out.println(
                    "Status           : "
                            + attendance.getStatus()
            );

        } else {

            System.out.println(
                    "\nNo attendance record found."
            );
        }

        if (marks != null && attendance != null) {

            double marksPercentage =
                    marks.calculatePercentage();

            double attendancePercentage =
                    attendance.calculatePercentage();

            String performance;

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
                    "\n---------- OVERALL PERFORMANCE ----------"
            );

            System.out.println(
                    "Performance : " + performance
            );
        }

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "             END OF REPORT"
        );

        System.out.println(
                "=========================================="
        );
    }
}