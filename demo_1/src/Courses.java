public class Courses {
    private String lectureCode;
    private String lectureName;

    public Courses() {
    }

    public Courses(String lectureCode, String lectureName) {
        this.lectureCode = lectureCode;
        this.lectureName = lectureName;
    }

    public String getLectureCode() {
        return lectureCode;
    }

    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }
}
