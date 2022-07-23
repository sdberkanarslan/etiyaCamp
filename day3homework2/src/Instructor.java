
public class Instructor extends User {
    int instructorId;
    String instructorName;
    String instructorCourse;



    public Instructor(int instructorId, String instructorName,String instructorCourse) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorCourse = instructorCourse;
    }

    public int getInstructorId() {

        return instructorId;
    }

    public void setInstructorId(int instructorId) {

        this.instructorId = instructorId;
    }

    public String getInstructorName() {

        return instructorName;
    }

    public void setInstructorName(String instructorName) {

        this.instructorName = instructorName;
    }

    public String getInstructorCourse() {

        return instructorCourse;
    }

    public void setInstructorCourse(String instructorCourse) {

        this.instructorCourse = instructorCourse;
    }
}