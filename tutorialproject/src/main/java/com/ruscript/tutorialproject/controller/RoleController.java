package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/roles-contain")
    public String findByPlaceContaining(
            @RequestParam(name = "name") String s,
            Model model){
        List<Role> roles = roleService.findByNameContainsIgnoreCase(s);
        if(s.isEmpty()){
            return "redirect:/roles-all";
        }
        else {
            model.addAttribute("roles", roles);
            return "role/AllRolesView";
        }
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

    @GetMapping("/role-detail/{id}")
    public String showRoleDetails(
            @PathVariable int id,
            Model model
    ){
        Role role_obj = roleService.findById(id);
        model.addAttribute("role", role_obj);
        return "role/RoleInfo";
    }

    @GetMapping("/role-delete/{id}")
    public String deleteRole(@PathVariable int id){
        roleService.deleteById(id);
        return "redirect:/roles-all";
    }

    @GetMapping("/role-update/{id}")
    public String updateRoleGet(
            @PathVariable int id,
            Model model
    ){
        model.addAttribute("role", roleService.findById(id));
        return "role/RoleUpdate";
    }

    @PostMapping("/role-update/{id}")
    public String updateRolePost(
            @PathVariable int id,
            @RequestParam String name
    ){
        Role role = roleService.findById(id);

        role.setName(name);

        roleService.saveRole(role);

        return "redirect:/roles-all";
    }

}
