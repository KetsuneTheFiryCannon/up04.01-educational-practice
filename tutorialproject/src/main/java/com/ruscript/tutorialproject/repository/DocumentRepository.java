package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
