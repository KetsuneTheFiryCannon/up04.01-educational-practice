package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Document;
import com.ruscript.tutorialproject.model.Personality;
import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.repository.PersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonalityController {

    private final PersonalityRepository personalityRepository;

    public PersonalityController(PersonalityRepository personalityRepository) {
        this.personalityRepository = personalityRepository;
    }

    @GetMapping("/personalities-all")
    public String findAll(Model model) {
        List<Personality> pers = personalityRepository.findAll();
        model.addAttribute("pers", pers);
        return "personality/AllPersonalitiesView";
    }


    @GetMapping("/personality-create")
    public String createDocumentGet(Personality personality) {
        return "personality/PersonalityCreate";
    }

    @PostMapping("/personality-create")
    public String createDocumentPost(@Validated Personality personality, BindingResult bindingResult) {

        personalityRepository.save(personality);
        return "redirect:/personalities-all";
    }
}
