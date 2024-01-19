package ru.alina_corp.seminar3.ex2;

/**
 * Описать собственную коллекцию – список на основе массива.
 * Коллекция должна иметь возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
 */
public class Main {
    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection<>();
        myCollection.add("Anna");
        myCollection.add("Alice");
        myCollection.add("Kate");
        myCollection.add("Oliver");

        for (Object object: myCollection) {
            System.out.println(object);
        }

        myCollection.remove(1);
        myCollection.remove("Oliver");
        System.out.println(myCollection);
    }
    
    
}
