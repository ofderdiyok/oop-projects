public class Student {
    private String studentID;
    private String studentName;
    private String studentSurname;

    public Student() {
    }

    public Student(String studentID, String studentName, String studentSurname) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }
}
