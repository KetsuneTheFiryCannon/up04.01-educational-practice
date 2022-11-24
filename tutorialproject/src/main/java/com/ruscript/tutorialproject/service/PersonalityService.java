package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Personality;
import com.ruscript.tutorialproject.repository.PersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalityService {

    private final PersonalityRepository personalityRepository;

    @Autowired
    public PersonalityService(PersonalityRepository personalityRepository) {
        this.personalityRepository = personalityRepository;
    }

    public List<Personality> findByFirstnameOrSecondnameOrThirdname (String s) { return personalityRepository.findByFirstnameContainsIgnoreCaseOrSecondnameContainsIgnoreCaseOrThirdnameContainsIgnoreCase(s, s, s); }

    public List<Personality> findAll() { return personalityRepository.findAll(); }

    public void savePersonality(Personality personality) { personalityRepository.save(personality); }

    public void deletePersonality(int id) { personalityRepository.deleteById(id); }
}
