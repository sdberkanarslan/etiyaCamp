package entities.concretes;

import entities.abstracts.IEntity;

public class Course implements IEntity {
    public String name;
    public double price;


    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }



}