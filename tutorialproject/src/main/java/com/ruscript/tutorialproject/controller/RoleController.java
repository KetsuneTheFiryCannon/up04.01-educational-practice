package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles-all")
    public String findAll(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "role/AllRolesView";
    }

    @GetMapping("/roles-find")
    public String findByName(
            @RequestParam(name = "name", required = true, defaultValue = "") String name,
            Model model){
        List<Role> roles = roleService.findByName(name);
        model.addAttribute("roles", roles);
        return "role/AllRolesView";
    }

    @GetMapping("/role-create")
    public String createRoleGet(Role role) {
        return "role/RoleCreate";
    }

    @PostMapping("/role-create")
    public String createRolePost(Role role){
        roleService.saveRole(role);
        return "redirect:/roles-all";
    }
}
