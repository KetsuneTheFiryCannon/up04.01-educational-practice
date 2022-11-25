package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Personality;
import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.service.PersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonalityController {

    private final PersonalityService personalityService;

    public PersonalityController(PersonalityService personalityService) {
        this.personalityService = personalityService;
    }

    @GetMapping("/personalities-all")
    public String findAll(Model model) {
        List<Personality> pers = personalityService.findAll();
        model.addAttribute("pers", pers);
        return "personality/AllPersonalitiesView";
    }


    @GetMapping("/personality-create")
    public String createPersonalityGet(Personality personality) {
        return "personality/PersonalityCreate";
    }

    @PostMapping("/personality-create")
    public String createPersonalityPost(@Validated Personality personality) {

        personalityService.savePersonality(personality);
        return "redirect:/personalities-all";
    }

    @GetMapping("/personality-contain")
    public String findByFirstnameOrSecondnameOrThirdname(
            @RequestParam(name = "name") String s,
            Model model){
        List<Personality> pers = personalityService.findByFirstnameOrSecondnameOrThirdname(s);
        if(pers.isEmpty()){
            return "redirect:/personalities-all";
        }
        else {
            model.addAttribute("pers", pers);
            return "personality/AllPersonalitiesView";
        }
    }
}
