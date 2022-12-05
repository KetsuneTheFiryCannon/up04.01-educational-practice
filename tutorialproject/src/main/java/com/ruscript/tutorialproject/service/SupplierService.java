package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Supplier;
import com.ruscript.tutorialproject.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    final
    SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void save(Supplier supplier) { supplierRepository.save(supplier); }

    public void delete(Supplier supplier) { supplierRepository.delete(supplier); }

    public List<Supplier> findAll() { return supplierRepository.findAll(); }

    public Supplier findById(int i) { return supplierRepository.findById(i).orElseThrow(); }

}
