package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Placement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacementRepository extends JpaRepository<Placement, Integer> {
}
