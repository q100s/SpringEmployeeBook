package pro.sky.java.course2.lesson6.springemployeebook.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    int maxNumberOfEmployees = 10;

    public List<Employee> showInfo() {
        return new ArrayList<>(employees);
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee has already added");
        }
        if (employees.size() >= maxNumberOfEmployees) {
            throw new EmployeeStorageIsFullException("The company isn't looking for new employees");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Employee doesn't exist");
        }
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!(employees.contains(employee))) {
            throw new EmployeeNotFoundException("Employee doesn't exist");
        }
        return employee;
    }
}
