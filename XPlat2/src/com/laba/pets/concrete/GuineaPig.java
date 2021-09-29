package com.laba.pets.concrete;

import com.laba.enums.AnimalType;
import com.laba.enums.FoodType;
import com.laba.pets.SeaPet;

public class GuineaPig extends SeaPet {
    private int age;

    public GuineaPig(String name, double requiredFoodAmount, FoodType possibleFood, double weight, int age) {
        super(name, requiredFoodAmount, possibleFood, weight);
        this.age = age;
        setAnimalType(AnimalType.RODENT);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "GuineaPig{" +
                super.toString() +
                "age=" + age +
                "}";
    }
}
