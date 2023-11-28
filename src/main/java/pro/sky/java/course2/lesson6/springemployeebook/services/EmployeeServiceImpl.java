package pro.sky.java.course2.lesson6.springemployeebook.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFirstName() + employee.getLastName())) {
            throw new EmployeeAlreadyAddedException("Employee has already added");
        }
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFirstName() + employee.getLastName())) {
            throw new EmployeeNotFoundException("Employee doesn't exist");
        }
        employees.remove(employee.getFirstName() + employee.getLastName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFirstName() + employee.getLastName())) {
            throw new EmployeeNotFoundException("Employee doesn't exist");
        }
        return employee;
    }
}
