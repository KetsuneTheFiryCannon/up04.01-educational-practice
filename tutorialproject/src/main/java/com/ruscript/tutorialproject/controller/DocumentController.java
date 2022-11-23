package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Document;
import com.ruscript.tutorialproject.model.Personality;
import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class DocumentController {

    private final DocumentRepository documentRepository;

    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping("/documents-all")
    public String findAll(Model model) {
        List<Document> docs = documentRepository.findAll();
        model.addAttribute("docs", docs);
        return "document/AllDocumentsView";
    }

    @GetMapping("/document-create")
    public String createDocumentGet(Document document) {
        return "document/DocumentCreate";
    }

    @PostMapping("/document-create")
    public String createDocumentPost(@Validated Document document, BindingResult bindingResult) {

        documentRepository.save(document);
        return "redirect:/documents-all";
    }
}
