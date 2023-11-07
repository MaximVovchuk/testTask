package com.botscrew.testTask.commands;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.entities.Lector;
import com.botscrew.testTask.services.DepartmentService;
import com.botscrew.testTask.services.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchByTemplateCommand implements CommandsGenerator {
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    @Override
    public String getCommandRegex() {
        return "^Global search by (\\w+)$";
    }

    @Override
    public void sendAnswer(String template) {
        List<String> answers = new ArrayList<>();
        lectorService.getAll().stream().map(Lector::getFullName)
                .filter(fullName -> fullName.contains(template)).forEach(answers::add);
        departmentService.getAll().stream().map(Department::getDepartmentName)
                .filter(name -> name.contains(template)).forEach(answers::add);
        for (int i = 0; i < answers.size(); i++) {
            System.out.print(answers.get(i));
            if (i < answers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
