package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Integer> {
}
