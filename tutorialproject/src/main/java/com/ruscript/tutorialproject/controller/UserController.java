package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.model.User;
import com.ruscript.tutorialproject.service.DocumentService;
import com.ruscript.tutorialproject.service.PersonalityService;
import com.ruscript.tutorialproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'HR')")
public class UserController {

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final DocumentService documentService;

    private final PersonalityService personalityService;

    public UserController(UserService userService, DocumentService documentService, PersonalityService personalityService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.documentService = documentService;
        this.personalityService = personalityService;
        this.passwordEncoder = passwordEncoder;
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

        user.setRole(Collections.singleton(Role.RENTER));

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