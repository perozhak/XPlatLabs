package com.laba.pets.concrete;

import com.laba.enums.FoodType;
import com.laba.pets.SeaPet;

public class AquariumFish extends SeaPet {
    private double price;

    public AquariumFish(String name, double requiredFoodAmount, FoodType possibleFood, double weight, double price) {
        super(name, requiredFoodAmount, possibleFood, weight);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "AquariumFish{" +
                super.toString() +
                "price=" + price +
                "}";
    }
}
