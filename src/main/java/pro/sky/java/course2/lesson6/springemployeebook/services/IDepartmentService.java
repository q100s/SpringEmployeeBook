package pro.sky.java.course2.lesson6.springemployeebook.services;

import pro.sky.java.course2.lesson6.springemployeebook.Employee;

import java.util.List;
import java.util.Map;

public interface IDepartmentService {
    Map<Integer, List<Employee>> separateAllByDepartment();

    List<Employee> getAllByDepartment(int department);

    double getMaxSalary(int department);

    double getMinSalary(int department);

    public double getSumOfSalaries(int department);
}
