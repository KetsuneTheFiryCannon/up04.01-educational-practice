package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByNameContainsIgnoreCase (String s);
}
