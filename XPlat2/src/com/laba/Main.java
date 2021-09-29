package com.laba;

import com.laba.enums.AnimalType;
import com.laba.enums.FoodType;
import com.laba.manager.PetManager;
import com.laba.pets.Pet;
import com.laba.pets.SeaPet;
import com.laba.pets.TerrestrialPet;
import com.laba.pets.concrete.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final PetManager manager = new PetManager(setupData());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isQuit = false;
        do {
            printMenu();
            String result = scanner.nextLine();
            switch (result) {
                case "1":
                    AnimalType type = getAnimalType();
                    for (int i = 0; i < manager.filterByType(type).size(); i++)
                        System.out.println(manager.filterByType(type).get(i)+"\n");
                    break;
                case "2":
                    performSorting();
                    for (int i = 0; i < manager.getList().size(); i++)
                        System.out.println(manager.getList().get(i)+"\n");
                    break;
                case "3":
                    isQuit = true;
                    break;
                default:
                    System.out.println("You have entered incorrect value. Try again");
            }
        } while(!isQuit);
        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("Choose one option:");
        System.out.println("1: Filter by animal type");
        System.out.println("2: Sort data");
        System.out.println("3: Exit");
    }

    private static AnimalType getAnimalType() {
        System.out.println("Choose your animal type: ");
        do {
            System.out.println("1 - Pisces\n2 - Bird\n3 - Four paws\n4 - Rodent\n5 - Reptile");
            String result = scanner.nextLine();
            switch (result) {
                case "1":
                    return AnimalType.PISCES;
                case "2":
                    return AnimalType.BIRD;
                case "3":
                    return AnimalType.FOUR_PAWS;
                case "4":
                    return AnimalType.RODENT;
                case "5":
                    return AnimalType.REPTILE;
                default:
                    System.out.println("You have entered incorrect value. Try again");
            }
        } while(true);
    }

    private static void performSorting() {
        boolean isQuit = false;
        do {
            printSortingMenu();
            String sortingMethod = scanner.nextLine();
            boolean isDescending = getSortingOrder();

            switch (sortingMethod) {
                case "1":
                    manager.sortByName(isDescending);
                    isQuit = true;
                    break;
                case "2":
                    manager.sortByAnimalType(isDescending);
                    isQuit = true;
                    break;
                case "3":
                    manager.sortByRequiredFoodAmount(isDescending);
                    isQuit = true;
                    break;
                case "4":
                    manager.sortByFood(isDescending);
                    isQuit = true;
                    break;
                case "5":
                    manager.sortByFoodAmountAndType(isDescending);
                    isQuit = true;
                default:
                    System.out.println("You have entered incorrect value. Try again");
            }
        } while(!isQuit);
    }

    private static void printSortingMenu() {
        System.out.println("Choose one option:");
        System.out.println("1: Sort by name");
        System.out.println("2: Sort by animal type");
        System.out.println("3: Sort by food amount");
        System.out.println("4: Sort by food type");
        System.out.println("5: Sort by food amount and type");
    }

    private static boolean getSortingOrder() {
        do {
            System.out.println("Choose sorting order: ");
            System.out.println("1 - Ascending\n2 - Descending");
            String order = scanner.nextLine();

            switch (order) {
                case "1":
                    return false;
                case "2":
                    return true;
                default:
                    System.out.println("You have entered incorrect value. Try again");
            }
        } while(true);
    }

    private static List<Pet> setupData() {
        List<Pet> list = new ArrayList<>();
        list.add(new Pet("Oleg", AnimalType.REPTILE, 5, FoodType.CANNED_FOOD));
        list.add(new Pet("Vasia", AnimalType.FOUR_PAWS, 20, FoodType.DRY_FOOD));
        list.add(new Pet("Igor", AnimalType.BIRD, 12, FoodType.WET_FOOD));

        list.add(new SeaPet("Oksana", 12, FoodType.ALGAE, 32));
        list.add(new SeaPet("Lyubov", 2, FoodType.RAW_MEAT, 3));
        list.add(new SeaPet("Sasha", 3, FoodType.ALGAE, 15));

        list.add(new TerrestrialPet("Alex", AnimalType.BIRD, 15, FoodType.RAW_MEAT, 2));
        list.add(new TerrestrialPet("Kyle", AnimalType.FOUR_PAWS, 8, FoodType.RAW_MEAT, 3));
        list.add(new TerrestrialPet("Misha", AnimalType.REPTILE, 10, FoodType.PATE, 4));

        list.add(new Parrot("Volodia", 0.5, FoodType.DRY_FOOD));
        list.add(new Parrot("Kostia", 2, FoodType.WET_FOOD));
        list.add(new Parrot("Pasha", 1, FoodType.DRY_FOOD));

        list.add(new AquariumFish("Lesia", 0.5, FoodType.DRY_FOOD, 0.25, 500));
        list.add(new AquariumFish("Taras", 2, FoodType.WET_FOOD, 0.3, 500));

        list.add(new GuineaPig("Masha", 1, FoodType.DRY_FOOD, 3, 500));
        list.add(new GuineaPig("Oleg", 2, FoodType.DRY_FOOD, 5, 500));

        list.add(new Cat("Dmytro", 10, FoodType.DRY_FOOD, 2, true));
        list.add(new Cat("Vitalii", 8, FoodType.DRY_FOOD, 4, false));

        list.add(new Dog("Viktor", 6, FoodType.RAW_MEAT, 2, true));
        list.add(new Dog("Valentyn", 3, FoodType.WET_FOOD, 1, false));

        return list;
    }
}