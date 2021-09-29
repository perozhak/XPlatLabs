package com.laba.pets.concrete;

import com.laba.enums.AnimalType;
import com.laba.enums.FoodType;
import com.laba.pets.Pet;

public class Parrot extends Pet {
    private String colour;
    public Parrot(String name, double requiredFoodAmount, FoodType possibleFood) {
        super(name, AnimalType.BIRD, requiredFoodAmount, possibleFood);
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                super.toString() +
                "colour='" + colour + '\'' +
                "}";
    }
}
