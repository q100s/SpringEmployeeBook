package pro.sky.java.course2.lesson6.springemployeebook.services;

import pro.sky.java.course2.lesson6.springemployeebook.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String secondName);

    Employee remove(String firstName, String secondName);

    Employee find(String firstName, String secondName);

    List<Employee> showInfo();
}
