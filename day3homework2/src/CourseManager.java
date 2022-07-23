import java.util.ArrayList;
import java.util.List;

public class CourseManager  {

    public void addCourse(Course course){

        System.out.println(course.getCourseName() + " Kursu Eklendi.");
    }


    public void deleteCourse(Course course){

        System.out.println(course.getCourseName() + " Kursu Silindi.");
    }

    public void updateCourse(Course course){

        System.out.println(course.getCourseName() + " Kurs Güncelledi.");
    }

    public List<Course> getAll(){
        return new ArrayList<Course>();
    }

}