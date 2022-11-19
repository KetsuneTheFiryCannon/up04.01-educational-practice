package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends CrudRepository<Client, UUID> {

    List<Client> findByName(String name);

    Optional<Client> findById(UUID id);
}