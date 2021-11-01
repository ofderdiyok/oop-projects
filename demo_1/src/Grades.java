public class Grades {
    private String lectureCode;
    private String StudentID;
    private String mt1;
    private String mt2;
    private String finalExam;
    private double finalGrade;

    public Grades() {
    }

    public Grades(String lectureCode, String studentID, String mt1, String finalExam, double finalGrade) {
        this.lectureCode = lectureCode;
        StudentID = studentID;
        this.mt1 = mt1;
        this.finalExam = finalExam;
        this.finalGrade = finalGrade;
    }

    public Grades(String lectureCode, String studentID, String mt1, String mt2, String finalExam, double finalGrade) {
        this.lectureCode = lectureCode;
        StudentID = studentID;
        this.mt1 = mt1;
        this.mt2 = mt2;
        this.finalExam = finalExam;
        this.finalGrade = finalGrade;
    }

    public String getLectureCode() {
        return lectureCode;
    }

    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getMt1() {
        return mt1;
    }

    public void setMt1(String mt1) {
        this.mt1 = mt1;
    }

    public String getMt2() {
        return mt2;
    }

    public void setMt2(String mt2) {
        this.mt2 = mt2;
    }

    public String getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(String finalExam) {
        this.finalExam = finalExam;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
}
