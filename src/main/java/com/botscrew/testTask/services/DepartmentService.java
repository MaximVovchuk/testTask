package com.botscrew.testTask.services;

import com.botscrew.testTask.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department getDepartment(String departmentName);
    List<Department> getAll();
}
