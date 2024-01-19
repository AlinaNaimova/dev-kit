package ru.alina_corp.seminar3.hw.ex3;


/**
 * Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен
 * иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары, а также
 * переопределение метода toString(), возвращающее строковое представление пары.
 */
public class Main {
    public static void main(String[] args) {
        RecordPair<String, Integer> pair = new RecordPair<>("Text", 10);
        System.out.println(pair);
    }
}
