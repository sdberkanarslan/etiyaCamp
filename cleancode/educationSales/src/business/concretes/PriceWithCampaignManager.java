package business.concretes;

import business.abstracts.PriceService;
import entities.concretes.Course;

import java.util.List;

public class PriceWithCampaignManager implements PriceService {
    @Override
    public void updatePrice(List<Course> courses) {
        for(Course course:courses){
            course.price=course.price-(course.price*getDiscountedRate());
        }
    }
    private  double getDiscountedRate(){
        return 0.38;
    }
}