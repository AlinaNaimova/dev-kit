package ru.alina_corp.seminar3.ex1;

import java.io.DataInput;
import java.io.InputStream;

public class MyClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T t;
    private V v;
    private K k;

    public MyClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printNames() {
        System.out.println("Имя класса для переменной T: " + t.getClass().getName());
        System.out.println("Имя класса для переменной V: " + v.getClass().getName());
        System.out.println("Имя класса для переменной K: " + k.getClass().getName());
    }
}
