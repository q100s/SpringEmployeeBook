package pro.sky.java.course2.lesson6.springemployeebook.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.FullStorageException;
import pro.sky.java.course2.lesson6.springemployeebook.services.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    void addPositive() {
        Employee expected = new Employee("Ivan", "Ivanov", 1, 1);
        assertEquals(employeeService.add("Ivan", "Ivanov", 1, 1), expected);
        assertTrue(employeeService.getAll().contains(expected));
    }

    @Test
    void addIntoFullStorage() {
        for (int i = 0; employeeService.getAll().size() != 6; i++) {
            employeeService.add("Name" + i, "SecondName", 1, 1);
        }
        assertThrows(FullStorageException.class, () ->
                employeeService.add("anyName", "anySecondName", 2, 2));
    }

    @Test
    void addNotUniqEmployee() {
        employeeService.add("Ivan", "Ivanov", 1, 1);
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                employeeService.add("Ivan", "Ivanov", 1, 1));
    }

    @Test
    void removeExpectedEmployee() {
        Employee expected = new Employee("Ivan", "Ivanov", 1, 1);
        employeeService.add("Ivan", "Ivanov", 1, 1);
        assertTrue(employeeService.getAll().contains(expected));
        employeeService.remove("Ivan", "Ivanov");
        assertFalse(employeeService.getAll().contains(expected));
    }

    @Test
    void removeUnexpectedEmployee() {
        employeeService.add("Ivan", "Ivanov", 1, 1);
        assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.remove("NotIvan", "NotIvanov"));
    }

    @Test
    void findExpectedEmployee() {
        Employee actual = new Employee("Ivan", "Ivanov", 1, 1);
        employeeService.add("Ivan", "Ivanov", 1, 1);
        Employee expected = employeeService.find("Ivan", "Ivanov");
        assertNotNull(expected);
        assertEquals(expected, actual);
    }

    @Test
    void findUnexpectedEmployee() {
        employeeService.add("Ivan", "Ivanov", 1, 1);
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("NotIvan", "NotIvanov"));
    }
}
