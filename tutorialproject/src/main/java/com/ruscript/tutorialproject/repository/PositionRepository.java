package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
