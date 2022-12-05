package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Document;
import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.model.User;
import com.ruscript.tutorialproject.repository.DocumentRepository;
import com.ruscript.tutorialproject.service.DocumentService;
import com.ruscript.tutorialproject.service.UserDetailsPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import java.util.Collection;
import java.util.List;

@Controller
public class DocumentController {

    public boolean checkRole(String role){
        UserDetailsPrincipal principal = (UserDetailsPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<Role> few = principal.user.role;
        for (Role role1:
                few) {
            if (role1.name().equals(role)){
            return true;
            }
        }
        return false;
    }
    
    @Autowired
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/documents-all")
    public String findAll(Model model) {
        try {
            if (checkRole("ADMIN") || checkRole("OFFICER")) {
                List<Document> docs = documentService.findAll();
                model.addAttribute("docs", docs);
                return "document/AllDocumentsView";
            }
        } catch (Exception e) {
        }
        return "Error";
    }

    @GetMapping("/document-create")
    public String createDocumentGet(Document document) {
        try {
            if (checkRole("ADMIN") || checkRole("OFFICER")) {
                return "document/DocumentCreate";
            }
        }
        catch (Exception e){}
        return "Error";
    }

    @PostMapping("/document-create")
    public String createDocumentPost(
            @Valid Document document, BindingResult bindingResult) {
        try {
            if (checkRole("ADMIN") || checkRole("OFFICER")) {
                if (bindingResult.hasErrors()) {
                    return "document/DocumentCreate";
                }
                documentService.save(document);
                return "redirect:/documents-all";
            }
        }catch (Exception ex){}
        return "Error";
    }

    @GetMapping("/document-delete/{id}")
    public String deleteById(@PathVariable int id){
        try {
            if (checkRole("ADMIN") || checkRole("OFFICER")) {
                documentService.deleteById(id);
                return "redirect:/documents-all";
            }
        }catch (Exception e){}
        return "Error";
    }

    @GetMapping("/document-update/{id}")
    public String up(
            @PathVariable int id,
            Document document,
            Model model
            ){
        try {
            if (checkRole("ADMIN") || checkRole("OFFICER")) {
                document = documentService.findById(id);
                model.addAttribute("document", document);
                return "document/DocumentUpdate";
            }
        }catch (Exception e){}
        return "Error";
    }

    @PostMapping("/document-update/{id}")
    public String updateString(
            Document document
    ){
        try {
            if (checkRole("ADMIN") || checkRole("OFFICER")) {
                documentService.save(document);

                return "redirect:/documents-all";
            }
        }catch (Exception e){}
        return "Error";
    }
}
