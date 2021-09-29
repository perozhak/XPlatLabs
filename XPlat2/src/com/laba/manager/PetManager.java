package com.laba.manager;

import com.laba.enums.AnimalType;
import com.laba.pets.Pet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PetManager {

    private final List<Pet> list;

    public PetManager(List<Pet> list) {
        this.list = list;
    }

    public static class StaticComparator implements Comparator<Pet> {
        @Override
        public int compare(Pet p1, Pet p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    private class InnerComparator implements Comparator<Pet> {
        @Override
        public int compare(Pet p1, Pet p2) {
            return (int) Math.signum(p1.getRequiredFoodAmount() - p2.getRequiredFoodAmount());
        }
    }

    public List<Pet> filterByType(AnimalType type) {
        return list.stream().filter(pet -> pet.getAnimalType() == type).collect(Collectors.toList());
    }

    public void sortByName(boolean isDescending) {
        list.sort(new StaticComparator());
        if (isDescending) {
            Collections.reverse(list);
        }
    }

    public void sortByAnimalType(boolean isDescending) {
        list.sort(new Comparator<>() {
            @Override
            public int compare(Pet p1, Pet p2) {
                return p1.getAnimalType().toString().compareTo(p2.getAnimalType().toString());
            }
        });
        if (isDescending) {
            Collections.reverse(list);
        }
    }

    public void sortByRequiredFoodAmount(boolean isDescending) {
        list.sort(new InnerComparator());
        if (isDescending) {
            Collections.reverse(list);
        }
    }

    public void sortByFood(boolean isDescending) {
        list.sort((p1, p2) -> p1.getPossibleFood().toString().compareTo(p2.getPossibleFood().toString()));
        if (isDescending) {
            Collections.reverse(list);
        }
    }

    public void sortByFoodAmountAndType(boolean isDescending) {
        Comparator<Pet> comparator = Comparator.comparing(Pet::getRequiredFoodAmount);
        comparator = comparator.thenComparing(pet -> pet.getPossibleFood().toString());
        list.sort(comparator);
        if (isDescending) {
            Collections.reverse(list);
        }
    }

    public List<Pet> getList() {
        return list;
    }
}
