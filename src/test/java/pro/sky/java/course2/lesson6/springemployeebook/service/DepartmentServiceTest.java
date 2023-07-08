package pro.sky.java.course2.lesson6.springemployeebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.services.DepartmentService;
import pro.sky.java.course2.lesson6.springemployeebook.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    public static final List<Employee> EMPLOYEES = List.of(
            new Employee("ivan", "ivanov", 10000, 1),
            new Employee("oleg", "olegov", 20000, 1),
            new Employee("sergey", "sergeev", 30000, 2),
            new Employee("Petr", "Petrov", 5000, 2),
            new Employee("Semen", "Semenov", 10000, 3),
            new Employee("Gena", "Genov", 1000, 3));
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void init() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
    }

    @Test
    void sum() {
        double actual = departmentService.getSumOfSalaries(1);
        assertEquals(30000, actual, 0.0000001);
    }

    @Test
    void findMax() {
        double actual = departmentService.getMaxSalary(2);
        assertEquals(30000, actual);
    }

    @Test
    void findMin() {
        double actual = departmentService.getMinSalary(2);
        assertEquals(5000, actual);
    }

    @Test
    void getAllByDepartment() {
        List<Employee> actual = departmentService.getAllByDepartment(1);
        List<Employee> expected = new ArrayList<>();
        expected.add(new Employee("ivan", "ivanov", 10000, 1));
        expected.add(new Employee("oleg", "olegov", 20000, 1));
        assertIterableEquals(actual, expected);
    }

    @Test
    void getAllByUnexpectedDepartment() {
        List<Employee> expected = departmentService.getAllByDepartment(4);
        assertTrue(expected.isEmpty());
    }

    @Test
    void separateAllByDepartment() {
        Map<Integer, List<Employee>> actual = departmentService.separateAllByDepartment();
        Employee sergey = new Employee("sergey", "sergeev", 30000, 2);
        assertTrue(actual.get(2).contains(sergey));
        assertFalse(actual.get(3).contains(sergey));
        assertEquals(3, actual.keySet().size());
    }
}
