public class Marks {

    private int studentId;
    private double mathematics;
    private double java;
    private double operatingSystems;

    // Constructor
    public Marks(int studentId, double mathematics, double java, double operatingSystems) {
        this.studentId = studentId;
        this.mathematics = mathematics;
        this.java = java;
        this.operatingSystems = operatingSystems;
    }

    // Get Student ID
    public int getStudentId() {
        return studentId;
    }

    // Get Mathematics Marks
    public double getMathematics() {
        return mathematics;
    }

    // Get Java Marks
    public double getJava() {
        return java;
    }

    // Get Operating Systems Marks
    public double getOperatingSystems() {
        return operatingSystems;
    }

    // Calculate Total Marks
    public double calculateTotal() {
        return mathematics + java + operatingSystems;
    }

    // Calculate Percentage
    public double calculatePercentage() {
        return calculateTotal() / 3;
    }

    // Calculate Grade
    public String calculateGrade() {

        double percentage = calculatePercentage();

        if (percentage >= 90) {
            return "A+";
        } 
        else if (percentage >= 80) {
            return "A";
        } 
        else if (percentage >= 70) {
            return "B";
        } 
        else if (percentage >= 60) {
            return "C";
        } 
        else if (percentage >= 50) {
            return "D";
        } 
        else {
            return "F";
        }
    }

    // Display Marks
    public void displayMarks() {

        System.out.println("\n========== MARKS ==========");
        System.out.println("Student ID        : " + studentId);
        System.out.println("Mathematics       : " + mathematics);
        System.out.println("Java              : " + java);
        System.out.println("Operating Systems : " + operatingSystems);
        System.out.println("---------------------------");
        System.out.println("Total Marks       : " + calculateTotal());
        System.out.println("Percentage        : " + calculatePercentage() + "%");
        System.out.println("Grade             : " + calculateGrade());
        System.out.println("===========================");
    }
}
