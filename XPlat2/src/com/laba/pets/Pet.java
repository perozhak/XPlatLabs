package com.laba.pets;

import com.laba.enums.AnimalType;
import com.laba.enums.FoodType;

public class Pet {
    private String name;
    private AnimalType animalType;
    private double requiredFoodAmount;
    private FoodType possibleFood;

    public Pet(String name, AnimalType animalType, double requiredFoodAmount, FoodType possibleFood) {
        this.name = name;
        this.animalType = animalType;
        this.requiredFoodAmount = requiredFoodAmount;
        this.possibleFood = possibleFood;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public double getRequiredFoodAmount() {
        return requiredFoodAmount;
    }

    public FoodType getPossibleFood() {
        return possibleFood;
    }

    public void setAnimalType(AnimalType type) {
        this.animalType = type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", animalType=" + animalType +
                ", requiredFoodAmount=" + requiredFoodAmount +
                ", possibleFood=" + possibleFood +
                "}";
    }
}
