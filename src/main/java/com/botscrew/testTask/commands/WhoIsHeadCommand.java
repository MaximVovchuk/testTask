package com.botscrew.testTask.commands;

import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
        String headOfDepartmentName = departmentService.getDepartment(departmentName).getHeadOfDepartment().getFullName();
        System.out.println("Head of " + departmentName + " department is " + headOfDepartmentName);
    }
}
