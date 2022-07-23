
public class Student {

    int studentId;
    String studentName;
    String studentLastName;
    String studentCourse;


    public Student(int studentId, String studentName, String studentLastName, String studentCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.studentCourse = studentCourse;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }
}

