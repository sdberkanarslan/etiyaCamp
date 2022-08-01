package business.concretes;

import business.abstracts.CourseService;
import business.abstracts.PriceService;
import dataAccess.abstracts.ICourseDal;
import entities.concretes.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManager implements CourseService {
    ICourseDal courseDal;
    PriceService priceService;

    public CourseManager(ICourseDal courseDal,PriceService priceService) {
        this.courseDal = courseDal;
        this.priceService=priceService;
    }

    @Override
    public void add(Course course) {

        courseDal.add(course);
    }

    @Override
    public List<Course> getAll() {

        List<Course>courses=courseDal.getAll();
        priceService.updatePrice(courses);
        return courses;
    }
}