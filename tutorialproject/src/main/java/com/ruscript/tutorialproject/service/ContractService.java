package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Contract;
import com.ruscript.tutorialproject.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    public final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public void save(Contract contract) { contractRepository.save(contract); }

    public void delete(Contract contract) { contractRepository.delete(contract); }

    public Contract findById(int id) { return contractRepository.findById(id).orElseThrow(); }

    public List<Contract> findByAll() { return contractRepository.findAll(); }
}
