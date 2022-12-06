package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Rent;
import com.ruscript.tutorialproject.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {


    public final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public Rent save(Rent rent) { return rentRepository.save(rent); }
    public void delete(int id) { rentRepository.deleteById(id); }
    public Rent findById(int id) { return rentRepository.findById(id).orElseThrow(); }
    public List<Rent> findAll() { return rentRepository.findAll(); }

}
