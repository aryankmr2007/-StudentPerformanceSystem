public class InputValidator {

    // Validate Student ID
    public static boolean isValidStudentId(int id) {

        return id > 0;
    }

    // Validate Student Name
    public static boolean isValidName(String name) {

        return name != null && !name.trim().isEmpty();
    }

    // Validate Course
    public static boolean isValidCourse(String course) {

        return course != null && !course.trim().isEmpty();
    }

    // Validate Marks
    public static boolean isValidMarks(double marks) {

        return marks >= 0 && marks <= 100;
    }

    // Validate Total Classes
    public static boolean isValidTotalClasses(int totalClasses) {

        return totalClasses > 0;
    }

    // Validate Attended Classes
    public static boolean isValidAttendedClasses(
            int totalClasses,
            int attendedClasses) {

        return attendedClasses >= 0
                && attendedClasses <= totalClasses;
    }
}