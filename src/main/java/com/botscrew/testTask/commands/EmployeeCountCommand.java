package com.botscrew.testTask.commands;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeCountCommand implements CommandsGenerator {
    private final DepartmentService departmentService;
    @Override
    public String getCommandRegex() {
        return "^Show count of employee for (\\w+)$";
    }

    @Override
    public void sendAnswer(String command) {
        Department department = departmentService.getDepartment(command);
        System.out.println(department.getLectors().size());
    }
}
