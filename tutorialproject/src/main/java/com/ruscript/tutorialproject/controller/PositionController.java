package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Document;
import com.ruscript.tutorialproject.model.Personality;
import com.ruscript.tutorialproject.model.Position;
import com.ruscript.tutorialproject.model.Supplier;
import com.ruscript.tutorialproject.repository.SupplierRepository;
import com.ruscript.tutorialproject.service.PersonalityService;
import com.ruscript.tutorialproject.service.PositionService;
import com.ruscript.tutorialproject.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'SOLDER')")
public class PositionController {

    public final SupplierService supplierService;

    public final PositionService positionService;

    public final PersonalityService personalityService;

    public PositionController(SupplierService supplierService, PositionService positionService, PersonalityService personalityService) {
        this.supplierService = supplierService;
        this.positionService = positionService;
        this.personalityService = personalityService;
    }

    @GetMapping("/position-config")
    public String findAll(Model model) {
        List<Supplier> sups = supplierService.findAll();
        List<Position> poses = positionService.findAll();
        List<Personality> pers = personalityService.findAll();
        model.addAttribute("sups", sups);
        model.addAttribute("poses", poses);
        model.addAttribute("pers", pers);
        return "supplier/CreatePosition";
    }

    @GetMapping("/supplier-create")
    public String createSupplierGet(Supplier supplier,
                                    Position position,
                                    Personality personality,
                                    Model model) {
        List<Supplier> sups = supplierService.findAll();
        List<Position> poses = positionService.findAll();
        List<Personality> pers = personalityService.findAll();
        model.addAttribute("sups", sups);
        model.addAttribute("poses", poses);
        model.addAttribute("pers", pers);
        return "supplier/CreatePosition";
    }

    @PostMapping("/supplier-create")
    public String createSupplierPost(
            @Validated Supplier supplier,
            Model model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "supplier/CreatePosition";
        }

        supplierService.save(supplier);

        return "redirect:/position-config";
    }
//
//    @GetMapping("/document-delete/{id}")
//    public String deleteById(@PathVariable int id){
//        try {
//            if (checkRole("ADMIN") || checkRole("OFFICER")) {
//                documentService.deleteById(id);
//                return "redirect:/documents-all";
//            }
//        }catch (Exception e){}
//        return "Error";
//    }
//
//    @GetMapping("/document-update/{id}")
//    public String up(
//            @PathVariable int id,
//            Document document,
//            Model model
//    ){
//        try {
//            if (checkRole("ADMIN") || checkRole("OFFICER")) {
//                document = documentService.findById(id);
//                model.addAttribute("document", document);
//                return "document/DocumentUpdate";
//            }
//        }catch (Exception e){}
//        return "Error";
//    }
//
//    @PostMapping("/document-update/{id}")
//    public String updateString(
//            Document document
//    ){
//        try {
//            if (checkRole("ADMIN") || checkRole("OFFICER")) {
//                documentService.save(document);
//
//                return "redirect:/documents-all";
//            }
//        }catch (Exception e){}
//        return "Error";
//    }
}
