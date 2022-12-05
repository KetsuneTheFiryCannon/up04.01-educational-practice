package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Placement;
import com.ruscript.tutorialproject.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {

    public final PlacementRepository placementRepository;

    public PlacementService(PlacementRepository placementRepository) {
        this.placementRepository = placementRepository;
    }

    public Placement save(Placement placement) { return placementRepository.save(placement); }

    public void delete(Placement placement) { placementRepository.delete(placement); }

    public List<Placement> findAll() { return placementRepository.findAll();}

    public Placement findById(int id) { return placementRepository.findById(id).orElseThrow(); }
}
