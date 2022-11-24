package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByName(String name);
}
