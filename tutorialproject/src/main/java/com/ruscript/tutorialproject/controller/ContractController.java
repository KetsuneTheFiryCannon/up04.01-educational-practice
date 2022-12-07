package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.*;
import com.ruscript.tutorialproject.repository.ContractRepository;
import com.ruscript.tutorialproject.service.ContractService;
import com.ruscript.tutorialproject.service.PositionService;
import com.ruscript.tutorialproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContractController {

    public final ContractService contractService;

    public final UserService userService;

    public final PositionService positionService;

    public ContractController(ContractService contractService, UserService userService, PositionService positionService) {
        this.contractService = contractService;
        this.userService = userService;
        this.positionService = positionService;
    }


    @GetMapping("/contracts-all")
    public String showContracts(Model model){
        List<Contract> contracts = contractService.findByAll();
        List<User> users = userService.findAll();
        List<Position> poses = positionService.findAll();
        model.addAttribute("contracts", contracts);
        model.addAttribute("users", users);
        model.addAttribute("poses", poses);
        return "contract/ContractConfig";
    }

    @GetMapping("/contract-create")
    public String createContracts(Model model){
        List<Contract> contracts = contractService.findByAll();
        List<User> users = userService.findAll();
        List<Position> poses = positionService.findAll();
        model.addAttribute("contracts", contracts);
        model.addAttribute("users", users);
        model.addAttribute("poses", poses);
        return "contract/ContractConfig";
    }

}
