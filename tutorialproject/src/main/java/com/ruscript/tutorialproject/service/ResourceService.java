package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Resource;
import com.ruscript.tutorialproject.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    final
    ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public void save(Resource resource) { resourceRepository.save(resource); }

    public void delete(Resource resource) { resourceRepository.delete(resource); }

}
