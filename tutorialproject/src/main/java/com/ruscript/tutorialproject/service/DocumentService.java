package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Document;
import com.ruscript.tutorialproject.model.Personality;
import com.ruscript.tutorialproject.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> findByPassportnumberIgnoreCaseContainsOrPassportseriesIgnoreCaseContains (String s) { return documentRepository.findByPassportnumberIgnoreCaseContainsOrPassportseriesIgnoreCaseContains(s, s); }

    public List<Document> findAll() { return documentRepository.findAll(); }

    public Document findById(int id) { return documentRepository.findById(id).orElseThrow(null); }

    public void save(Document document) { documentRepository.save(document); }

    public void deleteById(int id) { documentRepository.deleteById(id); }
}
