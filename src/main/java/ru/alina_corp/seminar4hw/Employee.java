package ru.alina_corp.seminar4hw;

public class Employee {
    private int employeeID;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int employeeID, String phoneNumber, String name, int experience) {
        this.employeeID = employeeID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}
