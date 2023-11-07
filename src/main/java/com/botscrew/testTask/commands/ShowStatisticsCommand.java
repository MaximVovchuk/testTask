package com.botscrew.testTask.commands;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.entities.Lector;
import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
        Department department = departmentService.getDepartment(departmentName);
        int assistantCount = 0;
        int associateCount = 0;
        int professorCount = 0;
        for (Lector lector : department.getLectors()) {
            switch (lector.getDegree()) {
                case ASSISTANT -> assistantCount++;
                case ASSOCIATE_PROFESSOR -> associateCount++;
                case PROFESSOR -> professorCount++;
            }
        }
        System.out.println("assistants - " + assistantCount);
        System.out.println("associate professors - " + associateCount);
        System.out.println("professors - " + professorCount);
    }
}
