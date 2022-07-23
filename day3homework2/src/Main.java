
public class Main {

    public static void main(String[] args) {
        Course course1 = new Course(1, "C# + ANGULAR", "Engin Demiroğ");
        Course course2 = new Course(2, "JavaScript", "Engin Demiroğ");
        Course course3 = new Course(3, "Java + React", "Engin Demiroğ");
        Course course4 = new Course(4, "Programlamaya Giriş İçin Temel Kurs", "Engin Demiroğ");

        Course[] courses = {course1,course2,course3,course4};

        for (Course course : courses) {
            System.out.println(course.getCourseId());
            System.out.println(course.getCourseName());
            System.out.println(course.getCourseInstructor());
        }

        User student1 = new User(1, "Berkan");
        User instructor1 = new Instructor(1, "Engin", "Java");

        CourseManager courseManager = new CourseManager();
        courseManager.addCourse(course1);
        courseManager.deleteCourse(course4);

        UserManager userManager = new UserManager();
        userManager.add(student1);

        UserManager userManager2 = new UserManager();
        userManager2.add(instructor1);

    }

}