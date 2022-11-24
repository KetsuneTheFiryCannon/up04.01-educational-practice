package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.model.User;
import com.ruscript.tutorialproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findById(int id){
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> findByName(String name){
        return roleRepository.findByName(name);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void deleteById(int id){
        roleRepository.deleteById(id);
    }
}
