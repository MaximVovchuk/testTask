package com.botscrew.testTask.services.impl;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.repositories.DepartmentRepository;
import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department getDepartment(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
