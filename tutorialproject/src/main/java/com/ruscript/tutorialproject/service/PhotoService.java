package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Photo;
import com.ruscript.tutorialproject.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    @Autowired
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void save(Photo photo) { this.photoRepository.save(photo); }
}
