package com.botscrew.testTask.commands;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
        Department department = departmentService.getDepartment(departmentName);
        double averageSalary = department.getLectors().stream().mapToDouble(
                lector -> lector.getSalary().doubleValue()).average().orElse(0);
        System.out.println("The average salary of " + departmentName + " is " + averageSalary);
    }
}
