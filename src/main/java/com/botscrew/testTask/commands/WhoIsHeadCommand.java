package com.botscrew.testTask.commands;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WhoIsHeadCommand implements CommandsGenerator {
    private final DepartmentService departmentService;

    @Override
    public String getCommandRegex() {
        return "^Who is head of department (\\w+)$";
    }

    @Override
    public void sendAnswer(String departmentName) {
        Optional<Department> department = departmentService.getDepartment(departmentName);
        if (department.isPresent()) {
            System.out.println("Head of " + departmentName + " department is " + department.get().getHeadOfDepartment().getFullName());
        } else {
            System.out.println("Department " + departmentName + " not found");
        }
    }
}
