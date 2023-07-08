package pro.sky.java.course2.lesson6.springemployeebook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.services.IDepartmentService;

import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    private final IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> separateAllByDepartment() {
        return departmentService.separateAllByDepartment();
    }

    @GetMapping(value = "/{id}/employees")
    public List<Employee> getAllByDepartment(@PathVariable("id") int id) {
        return departmentService.getAllByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalary(@PathVariable("id") int id) {
        return departmentService.getMaxSalary(id);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalary(@PathVariable("id") int id) {
        return departmentService.getMinSalary(id);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSumOfSalaries(@PathVariable("id") int id) {
        return departmentService.getSumOfSalaries(id);
    }
}
