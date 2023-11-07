package com.botscrew.testTask.repositories;

import com.botscrew.testTask.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector,Long> {
}
