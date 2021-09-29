package com.laba.pets;

import com.laba.enums.AnimalType;
import com.laba.enums.FoodType;

public class SeaPet extends com.laba.pets.Pet {

    private double weight;

    public SeaPet(String name, double requiredFoodAmount, FoodType possibleFood, double weight) {
        super(name, AnimalType.PISCES, requiredFoodAmount, possibleFood);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "SeaPet{" +
                super.toString() +
                "weight=" + weight +
                "}";
    }
}
