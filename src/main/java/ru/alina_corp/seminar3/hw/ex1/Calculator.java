package ru.alina_corp.seminar3.hw.ex1;

/**
 * Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(),
 * divide(), subtract(). Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {
    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number> double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number> double subtraction(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Нельзя делить на ноль!!!");
        }
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number> double divide(T a, T b) {
        return a.doubleValue() / b.doubleValue();
    }
}
