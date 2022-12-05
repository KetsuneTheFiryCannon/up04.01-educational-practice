package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}