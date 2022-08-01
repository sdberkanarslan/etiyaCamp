package ui;

import business.abstracts.CourseService;
import business.concretes.CourseManager;
import business.concretes.PriceWithCampaignManager;
import dataAccess.concretes.CourseDal;
import entities.concretes.Course;

public class Main {
    public static void main(String[] args) {
        Course course1=new Course("C#",1000);
        Course course2=new Course("java",1500);

        CourseService courseService=new CourseManager(new CourseDal(),new PriceWithCampaignManager());
        courseService.add(course1);
        courseService.add(course2);

        for (Course course:courseService.getAll()){
            System.out.println(course.price+" "+course.name);
        }

    }
}