package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
}
