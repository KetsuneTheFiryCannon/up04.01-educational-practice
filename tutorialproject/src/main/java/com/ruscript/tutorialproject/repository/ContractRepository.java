package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
