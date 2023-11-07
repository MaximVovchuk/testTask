package com.botscrew.testTask.commands;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AverageSalaryCommand implements CommandsGenerator {
    private final DepartmentService departmentService;

    @Override
    public String getCommandRegex() {
        return "^Show the average salary for the department (\\w+)$";
    }

    @Override
    public void sendAnswer(String departmentName) {
        Optional<Department> department = departmentService.getDepartment(departmentName);
        if (department.isPresent()) {
            double averageSalary = department.get().getLectors().stream().mapToDouble(
                    lector -> lector.getSalary().doubleValue()).average().orElse(0);
            System.out.println("The average salary of " + departmentName + " is " + averageSalary);
        } else {
            System.out.println("Department " + departmentName + " not found");
        }
    }
}
