package com.ruscript.tutorialproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/home")
    public String Home() {
        return "HomeView";
    }

    @GetMapping("/info")
    public String Info() {
        return "InfoView";
    }

    @GetMapping("/about")
    public String About(
            @RequestParam(name = "first_key", required = true, defaultValue = "0") int a,
            @RequestParam(name = "second_key", required = true, defaultValue = "0") int b,
            @RequestParam(name = "sign", required = true, defaultValue = "+") char c,
            Model model) {
        if (a != 0 && b != 0) {
            model.addAttribute("numone", a);
            model.addAttribute("numtwo", b);
            model.addAttribute("sign", c);
            double temp = 0;
            switch (c) {
                case '+':
                    temp = a + b;
                    break;
                case '-':
                    temp = a - b;
                    break;
                case '*':
                    temp = a * b;
                    break;
                case '/':
                    temp = a / b;
                    break;
            }
            model.addAttribute("total", temp);
        }
        return "AboutView";
    }

    @PostMapping("/about")
    public String PostAbout(
            @RequestParam(name = "first_key", required = true, defaultValue = "0") double a,
            @RequestParam(name = "second_key", required = true, defaultValue = "0") double b,
            @RequestParam(name = "sign", required = true, defaultValue = "0") char c,
            Model model) {
        if (a != 0 && b != 0) {
            model.addAttribute("numone", a);
            model.addAttribute("numtwo", b);
            model.addAttribute("sign", c);
            double temp = 0;
            switch (c) {
                case '+':
                    temp = a + b;
                    break;
                case '-':
                    temp = a - b;
                    break;
                case '*':
                    temp = a * b;
                    break;
                case '/':
                    temp = a / b;
                    break;
            }
            model.addAttribute("total", temp);
        }
        return "AboutView";
    }
}