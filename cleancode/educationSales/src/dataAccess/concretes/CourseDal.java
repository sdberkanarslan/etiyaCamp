package dataAccess.concretes;

import dataAccess.abstracts.ICourseDal;
import entities.concretes.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDal implements ICourseDal {
    List<Course>courses=new ArrayList<>();

    @Override
    public void add(Course course) {
        courses.add(course);
        System.out.println("Course added");
    }

    @Override
    public List<Course> getAll() {
        return courses;

    }
}
