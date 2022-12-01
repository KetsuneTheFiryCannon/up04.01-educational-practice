package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Advertisement;
import com.ruscript.tutorialproject.model.Document;
import com.ruscript.tutorialproject.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public void save(Advertisement advertisement) { advertisementRepository.save(advertisement); }

    public List<Advertisement> findAll() { return advertisementRepository.findAll(); }

    public Advertisement findByNameAdvertisementid(int i) { return advertisementRepository.findByAdvertisementid(i); }

}
