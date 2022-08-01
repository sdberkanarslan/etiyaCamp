package dataAccess.abstracts;

import entities.concretes.Course;

import java.util.List;

public interface ICourseDal {
    void add(Course course);
    List<Course>getAll();
}