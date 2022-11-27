package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Document;
import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.repository.DocumentRepository;
import com.ruscript.tutorialproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/documents-all")
    public String findAll(Model model) {
        List<Document> docs = documentService.findAll();
        model.addAttribute("docs", docs);
        return "document/AllDocumentsView";
    }

    @GetMapping("/document-create")
    public String createDocumentGet(Document document) {
        return "document/DocumentCreate";
    }

    @PostMapping("/document-create")
    public String createDocumentPost(@Valid Document document, BindingResult bindingResult) {

//        bindingResult.addError(new ObjectError("defaultMessage", "Wrong input"));

        if(bindingResult.hasErrors()){
            return "document/DocumentCreate";
        }
        documentService.save(document);
        return "redirect:/documents-all";
    }

    @GetMapping("/document-delete/{id}")
    public String deleteById(@PathVariable int id){
        documentService.deleteById(id);
        return "redirect:/documents-all";
    }

    @GetMapping("/document-update/{id}")
    public String up(
            @PathVariable int id,
            Document document,
            Model model
            ){
        document = documentService.findById(id);
        model.addAttribute("document", document);
        return "document/DocumentUpdate";
    }

    @PostMapping("/document-update/{id}")
    public String updateString(
            Document document
    ){
        documentService.save(document);

        return "redirect:/documents-all";
    }
}
