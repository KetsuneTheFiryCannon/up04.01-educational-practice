package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Position;
import com.ruscript.tutorialproject.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public void save(Position position) { positionRepository.save(position); }
    public void delete(int id) { positionRepository.deleteById(id); }
    public Position findById(int id) { return positionRepository.findById(id).orElseThrow(); }
    public List<Position> findAll() { return positionRepository.findAll(); }

}
