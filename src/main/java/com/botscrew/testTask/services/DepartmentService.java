package com.botscrew.testTask.services;

import com.botscrew.testTask.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Optional<Department> getDepartment(String departmentName);
    List<Department> getAll();
}
