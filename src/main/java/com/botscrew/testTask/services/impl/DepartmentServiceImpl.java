package com.botscrew.testTask.services.impl;

import com.botscrew.testTask.entities.Department;
import com.botscrew.testTask.repositories.DepartmentRepository;
import com.botscrew.testTask.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Optional<Department> getDepartment(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
