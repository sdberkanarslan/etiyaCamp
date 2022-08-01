package business.concretes;

import business.abstracts.PriceService;
import entities.concretes.Course;

import java.util.List;

public class StandartPriceManager implements PriceService {
    @Override
    public void updatePrice(List<Course> courses) {
        for(Course course:courses){
            System.out.println(course.price);
        }
    }
}