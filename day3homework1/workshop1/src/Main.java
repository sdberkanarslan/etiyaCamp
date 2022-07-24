
public class Main {

    public static void main(String[] args) {
        Course course1 = new Course(1, "C# + ANGULAR", "Engin Demiroğ");
        Course course2 = new Course(2, "JavaScript", "Engin Demiroğ");
        Course course3 = new Course(3, "Java + React", "Engin Demiroğ");
        Course course4 = new Course(4, "Programlamaya Giriş İçin Temel Kurs", "Engin Demiroğ");

        Course[] courses = {course1,course2,course3,course4};

        for (Course course : courses) {
            System.out.println(course.courseId);
            System.out.println(course.courseName);
            System.out.println(course.courseInstructor);
        }



        CourseManager courseManager = new CourseManager();
        courseManager.addCourse(course1);
        courseManager.deleteCourse(course4);


    }

}