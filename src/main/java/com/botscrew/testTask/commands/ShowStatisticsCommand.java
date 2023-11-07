package com.botscrew.testTask.commands;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.entities.Lector;
import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShowStatisticsCommand implements CommandsGenerator {
    private final DepartmentService departmentService;

    @Override
    public String getCommandRegex() {
        return "^Show (\\w+) statistics$";
    }

    @Override
    public void sendAnswer(String departmentName) {
        Optional<Department> department = departmentService.getDepartment(departmentName);
        if (department.isPresent()) {
            int assistantCount = 0;
            int associateCount = 0;
            int professorCount = 0;
            for (Lector lector : department.get().getLectors()) {
                switch (lector.getDegree()) {
                    case ASSISTANT -> assistantCount++;
                    case ASSOCIATE_PROFESSOR -> associateCount++;
                    case PROFESSOR -> professorCount++;
                }
            }
            System.out.println("assistants - " + assistantCount);
            System.out.println("associate professors - " + associateCount);
            System.out.println("professors - " + professorCount);
        } else {
            System.out.println("Department " + departmentName + " not found");
        }
    }
}
