package ru.alina_corp.seminar3.ex2;

import ru.alina_corp.seminar3.ex3.MyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Описать собственную коллекцию – список на основе массива.
 * Коллекция должна иметь возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
 */
public class MyCollection<T> implements Iterable<T> {
    private Object[] array; // Массив для хранения элементов, тип Object для поддержки любых типов данных
    private int size; // Текущий размер списка
    private static final int DEFAULT_CAPACITY = 10; // Начальная емкость массива по умолчанию

    public MyCollection() {
        this.array = new Object[DEFAULT_CAPACITY]; // Создаем массив с начальной емкостью
        this.size = 0; // Начальный размер списка равен 0
    }

    public void add(T element) {
        if (size >= array.length) {
            // Если массив заполнен, увеличиваем его размер в два раза
            Object[] newArray = new Object[size * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = element; // Добавляем элемент в конец массива
        size++; // Увеличиваем размер списка
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
            size--;
        }
    }


    public void remove(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                remove(i);
                return;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (size != 0) {
            stringBuilder.append(array[0]);
        }
        for ( int i = 0; i < size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(array[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((T)array[i]);
        }
        return new MyIterator<>(list);
    }
}
