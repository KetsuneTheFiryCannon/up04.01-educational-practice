package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    public List<Advertisement> findByAdvertisementnameContainsIgnoreCase(String s);
}