package com.laba.pets.concrete;

import com.laba.enums.AnimalType;
import com.laba.enums.FoodType;
import com.laba.pets.TerrestrialPet;

public class Cat extends TerrestrialPet {
    private boolean hasWool;

    public Cat(String name, double requiredFoodAmount, FoodType possibleFood, int length, boolean hasWool) {
        super(name, AnimalType.FOUR_PAWS, requiredFoodAmount, possibleFood, length);
        this.hasWool = hasWool;
    }

    public boolean hasWool() {
        return hasWool;
    }

    @Override
    public String toString() {
        return "Cat{" +
                super.toString() +
                "hasWool=" + hasWool +
                "}";
    }
}
