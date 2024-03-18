package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static HashMap<String, ArrayList<String>> mapDishes;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        mapDishes = new HashMap<>();

        while (true) {
            printMenu();
            String command = scanner.nextLine();
            command = command.trim();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    printAllDishes();
                    break;
                case "4":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Вывести все меню");
        System.out.println("4 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dishType = dishType.trim();
        dishName = dishName.trim();

        if (mapDishes.containsKey(dishType)) {
            mapDishes.get(dishType).add(dishName);
        } else {
            ArrayList<String> newArr = new ArrayList<>();
            newArr.add(dishName);
            mapDishes.put(dishType, newArr);
        }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        nextItem = nextItem.trim();

        ArrayList<String> selectedDishes = new ArrayList<>();

        while (!nextItem.isEmpty()) {
            if (mapDishes.containsKey(nextItem)) {
                selectedDishes.add(nextItem);
            } else {
                System.out.println("Такого типа не существует!\nВведите еще раз.");
            }
            nextItem = scanner.nextLine();
            nextItem = nextItem.trim();
        }

        dc = new DinnerConstructor(mapDishes, selectedDishes, numberOfCombos);
    }

    private static void printAllDishes() {
        if (mapDishes.isEmpty()) {
            System.out.println("Меню пустое :(\n");
            return;
        }

        System.out.println("Меню");
        System.out.println(mapDishes);
    }
}
