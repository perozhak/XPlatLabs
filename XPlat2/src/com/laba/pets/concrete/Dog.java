package com.laba.pets.concrete;

import com.laba.enums.AnimalType;
import com.laba.enums.FoodType;
import com.laba.pets.TerrestrialPet;

public class Dog extends TerrestrialPet {
    private boolean isYoung;

    public Dog(String name, double requiredFoodAmount, FoodType possibleFood, int length, boolean isYoung) {
        super(name, AnimalType.FOUR_PAWS, requiredFoodAmount, possibleFood, length);
        this.isYoung = isYoung;
    }

    public boolean isYoung() {
        return isYoung;
    }

    @Override
    public String toString() {
        return "Dog{" +
                super.toString() +
                "isYoung=" + isYoung +
                "}";
    }
}
