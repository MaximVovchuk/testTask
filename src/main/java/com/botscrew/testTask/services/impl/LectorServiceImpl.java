package com.botscrew.testTask.services.impl;

import com.botscrew.testTask.entities.Lector;
import com.botscrew.testTask.repositories.LectorRepository;
import com.botscrew.testTask.services.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public List<Lector> getAll() {
        return lectorRepository.findAll();
    }
}
