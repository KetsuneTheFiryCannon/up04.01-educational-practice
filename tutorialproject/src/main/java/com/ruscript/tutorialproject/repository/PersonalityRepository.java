package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Personality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalityRepository extends JpaRepository<Personality, Integer> {
}
