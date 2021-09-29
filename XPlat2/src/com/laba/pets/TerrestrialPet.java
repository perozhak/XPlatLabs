package com.laba.pets;

import com.laba.enums.AnimalType;
import com.laba.enums.FoodType;

public class TerrestrialPet extends com.laba.pets.Pet {

    private int length;

    public TerrestrialPet(String name, AnimalType animalType, double requiredFoodAmount, FoodType possibleFood, int length) {
        super(name, animalType, requiredFoodAmount, possibleFood);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "TerrestrialPet{" +
                super.toString() +
                "length=" + length +
                "}";
    }
}
