package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    public List<Document> findByPassportnumberIgnoreCaseContainsOrPassportseriesIgnoreCaseContains(String s, String s1);
}
