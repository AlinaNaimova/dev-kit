package ru.alina_corp.seminar5hw;

/**
 * Семафор — это средство для синхронизации доступа к какому-то ресурсу.
 *
 * Его особенность заключается в том, что при создании механизма синхронизации он использует счетчик.
 */

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;
    private static Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];

    public static void main(String[] args) {
        // Инициализация семафоров для вилок
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1);
        }

        // Создание потоков для каждого философа
        String[] philosopherNames = {"Сократ", "Платон", "Аристотель", "Декарт", "Ницше"};
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            final int philosopherId = i;
            Thread philosopherThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            think(philosopherNames[philosopherId]);
                            takeForks(philosopherId);
                            eat(philosopherNames[philosopherId]);
                            putForks(philosopherId);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            philosopherThread.start();
        }
    }

    // Метод для размышления
    private static void think(String philosopherName) throws InterruptedException {
        System.out.println("Философ " + philosopherName + " размышляет");
        Thread.sleep(1000); // Симуляция размышления
    }

    // Метод для приема пищи
    private static void eat(String philosopherName) throws InterruptedException {
        System.out.println("Философ " + philosopherName + " ест");
        Thread.sleep(1000); // Симуляция приема пищи
    }

    // Метод для взятия вилок
    private static void takeForks(int philosopherId) throws InterruptedException {
        int leftFork = philosopherId;
        int rightFork = (philosopherId + 1) % NUM_PHILOSOPHERS;

        forks[leftFork].acquire();
        forks[rightFork].acquire();
    }

    // Метод для возвращения вилок на стол
    private static void putForks(int philosopherId) {
        int leftFork = philosopherId;
        int rightFork = (philosopherId + 1) % NUM_PHILOSOPHERS;

        forks[leftFork].release();
        forks[rightFork].release();
    }
}
