package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Personality;
import com.ruscript.tutorialproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalityRepository extends JpaRepository<Personality, Integer> {
    List<Personality> findByFirstnameContainsIgnoreCaseOrSecondnameContainsIgnoreCaseOrThirdnameContainsIgnoreCase (String s, String s1, String s2);
}
