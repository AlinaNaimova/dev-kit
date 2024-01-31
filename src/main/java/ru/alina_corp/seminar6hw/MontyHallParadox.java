package ru.alina_corp.seminar6hw;
/**
 * В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла и наглядно убедиться
 * в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
 * Необходимо:
 * Создать свой Java Maven или Gradle проект;
 * Самостоятельно реализовать прикладную задачу;
 * Сохранить результат в HashMap<шаг теста, результат>
 * Вывести на экран статистику по победам и поражениям
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        Map<Integer, String> results = new HashMap<>();

        int wins = 0;
        int losses = 0;

        for (int i = 1; i <= 1000; i++) {
            boolean prizeDoor = new Random().nextBoolean();
            int chosenDoor = new Random().nextInt(3);

            int openedDoor;
            do {
                openedDoor = new Random().nextInt(3);
            } while (openedDoor == chosenDoor || (openedDoor == (prizeDoor ? 1 : 0)));

            boolean switchDoor = new Random().nextBoolean();
            if (switchDoor) {
                chosenDoor = 3 - chosenDoor - openedDoor;
            }

            if (chosenDoor == (prizeDoor ? 1 : 0)) {
                wins++;
                results.put(i, "win");
            } else {
                losses++;
                results.put(i, "lose");
            }
        }

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Results: " + results);
    }
}
