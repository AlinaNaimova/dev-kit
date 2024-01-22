package ru.alina_corp.seminar4hw;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private List<Employee> employees;

    public EmployeeList(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }


    public List<String> findPhoneNumbersByName(String name) {
        List<String> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                result.add(employee.getPhoneNumber());
            }
        }
        return result;
    }


    public Employee findEmployeeByEmployeeId(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeId) {
                return employee;
            }
        }
        return null; // Если сотрудник с указанным табельным номером не найден
    }


}
