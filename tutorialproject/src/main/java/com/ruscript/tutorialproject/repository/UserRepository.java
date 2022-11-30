package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByUserlogin(String s);
}
