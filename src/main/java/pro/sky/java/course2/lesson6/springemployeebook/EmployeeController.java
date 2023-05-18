package pro.sky.java.course2.lesson6.springemployeebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson6.springemployeebook.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService employeeService) {
        this.service = employeeService;
    }

    @GetMapping
    public List<Employee> showInfo() {
        return service.showInfo();
    }

    @GetMapping("/add")
    public Employee add(String firstName, String lastName) {
        return service.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(String firstName, String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(String firstName, String lastName) {
        return service.find(firstName, lastName);
    }
}
