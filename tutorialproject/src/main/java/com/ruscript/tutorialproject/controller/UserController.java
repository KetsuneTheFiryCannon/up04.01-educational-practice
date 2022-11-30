package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Document;
import com.ruscript.tutorialproject.model.Personality;
import com.ruscript.tutorialproject.model.User;
import com.ruscript.tutorialproject.service.DocumentService;
import com.ruscript.tutorialproject.service.PersonalityService;
import com.ruscript.tutorialproject.service.RoleService;
import com.ruscript.tutorialproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    private final UserService userService;

    private final DocumentService documentService;

    private final PersonalityService personalityService;

    public UserController(UserService userService, RoleService roleService, DocumentService documentService, PersonalityService personalityService) {
        this.userService = userService;
        this.roleService = roleService;
        this.documentService = documentService;
        this.personalityService = personalityService;
    }

    @GetMapping("/registration")
    private String RegistrationGet(User user){
        return "/Authentication/registration";
    }

    @PostMapping("/registration")
    private String RegistrationPost(String s, User user, Model model){
        User user_db = userService.findByUserloginContainsIgnoreCase(s);

        if(user_db != null){
            model.addAttribute("message", "User already exists");
            return  "/Authentication/registration";
        }

        user.setStatus(true);

        user.setUserpassword(new BCryptPasswordEncoder().encode(user.getUserpassword()));

        userService.saveUser(user);

        return "redirect:/home";
    }

    @GetMapping("/users-all")
    public String AllUsers(Model model){
        List<User> user = userService.findAll();
        model.addAttribute("user_list", user);

        return "user/AllUsersView";
    }
}