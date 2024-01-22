package ru.alina_corp.seminar4hw;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 1. Создать справочник сотрудников
 * Необходимо:
 * ● Создать класс справочник сотрудников, который
 * содержит внутри коллекцию сотрудников - каждый
 * сотрудник должен иметь следующие атрибуты:
 * ○ Табельный номер
 * ○ Номер телефона
 * ○ Имя
 * ○ Стаж
 * ● Добавить метод, который ищет сотрудника по стажу
 * (может быть список)
 * ● Добавить метод, который выводит номер телефона
 * сотрудника по имени (может быть список)
 * ● Добавить метод, который ищет сотрудника по
 * табельному номеру
 * ● Добавить метод добавление нового сотрудника в
 * справочник
 */
public class Main {
    public static void main(String[] args) {
        // Создаем список сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "+7(827)467-01-79", "Туманов Тимофей Фёдорович", 5));
        employees.add(new Employee(2, "+7(855)358-56-47", "Мельникова Майя Матвеевна", 3));
        employees.add(new Employee(3, "+7(739)052-47-84", "Михайлов Александр Егорович", 7));
        employees.add(new Employee(4, "+7(306)295-98-87", "Андреева Виктория Павловна", 10));
        employees.add(new Employee(5, "+7(642)901-16-28", "Селиванов Андрей Иванович", 5));
        employees.add(new Employee(6, "+7(062)776-45-92", "Михайлов Макар Кириллович", 7));
        // Создаем объект справочника сотрудников
        EmployeeList list = new EmployeeList(employees);

        // Ищем сотрудников по стажу
        List<Employee> employeesWithExperience = list.findEmployeesByExperience(5);
        System.out.println("Сотрудники со стажем 5 лет:");
        for (Employee employee : employeesWithExperience) {
            System.out.println(employee.getName());
        }

        // Выводим номера телефонов сотрудников по имени
        List<String> PhoneNumByName = list.findPhoneNumbersByName("Мельникова Майя Матвеевна");
        System.out.println("Номера телефонов для Мельникова Майя Матвеевна:");
        for (String phoneNumber : PhoneNumByName) {
            System.out.println(phoneNumber);
        }

        // Ищем сотрудника по табельному номеру
        Employee employeeWithCertainID = list.findEmployeeByEmployeeId(6);
        if (employeeWithCertainID != null) {
            System.out.println("Сотрудник с табельным номером 6 найден: " + employeeWithCertainID.getName());
        } else {
            System.out.println("Сотрудник с табельным номером 6 не найден");
        }



    }
}
