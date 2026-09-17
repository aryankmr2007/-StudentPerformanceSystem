public class Student {

    private int id;
    private String name;
    private String course;

    // Constructor
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // Get Student ID
    public int getId() {
        return id;
    }

    // Get Student Name
    public String getName() {
        return name;
    }

    // Get Student Course
    public String getCourse() {
        return course;
    }

    // Set Student Name
    public void setName(String name) {
        this.name = name;
    }

    // Set Student Course
    public void setCourse(String course) {
        this.course = course;
    }

    // Display Student Details
    public void displayStudent() {
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
    }
}