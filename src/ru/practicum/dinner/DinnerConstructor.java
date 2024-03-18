package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    DinnerConstructor() {

    }

    DinnerConstructor(HashMap<String, ArrayList<String>> mapDishes, ArrayList<String> selectedDishes, int numberOfCombos) {
        Random ran = new Random();
        ArrayList<String> combos = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            for (int j = 0; j < selectedDishes.size(); j++) {
                String tempDish = selectedDishes.get(j);
                ArrayList<String> tempArr = mapDishes.get(tempDish);
                combos.add(tempArr.get(ran.nextInt(tempArr.size())));
            }

            System.out.println("Комбо " + (i + 1));
            System.out.println(combos);
            combos = new ArrayList<>();
        }

    }

}
