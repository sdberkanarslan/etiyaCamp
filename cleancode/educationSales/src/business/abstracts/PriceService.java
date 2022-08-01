package business.abstracts;

import entities.concretes.Course;

import java.util.List;

public interface PriceService {
    void updatePrice(List<Course>courses);
}