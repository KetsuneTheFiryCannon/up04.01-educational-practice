package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.*;
import com.ruscript.tutorialproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Controller
@PreAuthorize("hasAnyAuthority('RENTER', 'ADMIN')")
public class PlacementController {

    public final PlacementService placementService;

    public final RoomService roomService;

    public final RentService rentService;

    public final UserService userService;

    public PlacementController(PlacementService placementService, RoomService roomService, RentService rentService, UserService userService) {
        this.placementService = placementService;
        this.roomService = roomService;
        this.rentService = rentService;
        this.userService = userService;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/placements-all")
    public String findAll(Model model,
                          Placement placement) {
        List<Placement> placements = placementService.findAll();
        List<Room> rooms = roomService.findAll();
        model.addAttribute("places", placements);
        model.addAttribute("rooms", rooms);
        return "placement/AllPlacementsView";
    }

    @GetMapping("/placement-create")
    public String createPlacementGet(
            Placement placement,
            Model model,
            BindingResult bindingResult) {
        List<Placement> placements = placementService.findAll();
        List<Room> rooms = roomService.findAll();

        model.addAttribute("places", placements);
        model.addAttribute("rooms", rooms);

        return "placement/AllPlacementsView";
    }

    @PostMapping("/placement-create")
    public String createPlacementPost(
            @RequestParam int roomid,
            @Validated Placement placement,
            @Validated Room room,
            Model model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "placement/AllPlacementsView";
        }

        List<Placement> placements = placementService.findAll();
        List<Room> rooms = roomService.findAll();
        model.addAttribute("places", placements);
        model.addAttribute("rooms", rooms);

        Room room1 = roomService.findById(roomid);

        placement.setRoomfk(room1);

        placementService.save(placement);
        return "redirect:/placements-all";
    }

    @GetMapping("/room-create")
    public String createRoomGet(
            Placement placement,
            Room room,
            Model model) {
        List<Placement> placements = placementService.findAll();
        List<Room> rooms = roomService.findAll();
        model.addAttribute("places", placements);
        model.addAttribute("rooms", rooms);
        return "placement/AllPlacementsView";
    }

    @PostMapping("/room-create")
    public String createRoomPost(
            Placement placement,
            Room room,
            @RequestParam("file") MultipartFile file,
            Model model,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "placement/AllPlacementsView";
        }

        List<Placement> placements = placementService.findAll();
        List<Room> rooms = roomService.findAll();
        model.addAttribute("places", placements);
        model.addAttribute("rooms", rooms);

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String uuid = UUID.randomUUID().toString();
        String resultFileName = uuid + "." + file.getOriginalFilename();

        try {
            file.transferTo(new File(uploadPath + "/" + resultFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        room.setRoomname(resultFileName);
        roomService.save(room);
        return "redirect:/placements-all";
    }


    @GetMapping("/rent-create")
    public String createRentGet(
            Placement placement,
            Room room,
            Rent rent,
            User user,
            Model model) {
        List<Placement> placements = placementService.findAll();
        List<Room> rooms = roomService.findAll();
        List<Rent> rents = rentService.findAll();
        List<User> users = userService.findAll();
        model.addAttribute("places", placements);
        model.addAttribute("rooms", rooms);
        model.addAttribute("rents", rents);
        model.addAttribute("users", users);
        return "placement/ContractView";
    }

    @PostMapping("/rent-create")
    public String createRentPost(
            Placement placement,
            Room room,
            Rent rent,
            Model model,
            @RequestParam int place,
            @RequestParam String login,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "placement/ContractView";
        }

        List<Placement> placements = placementService.findAll();
        List<Room> rooms = roomService.findAll();
        List<Rent> rents = rentService.findAll();
        List<User> users = userService.findAll();

        model.addAttribute("places", placements);
        model.addAttribute("rooms", rooms);
        model.addAttribute("rents", rents);
        model.addAttribute("users", users);

        User user1 = userService.findByUserloginContainsIgnoreCase(login);

        if (rent.getRentcontractstart().after(rent.getRentcontractend())) {
            Date temp = rent.getRentcontractstart();
            rent.setRentcontractstart(rent.getRentcontractend());
            rent.setRentcontractend(temp);
        }

        Placement placement1 = placementService.findById(place);

        rent.setTotal(placement1.getPlacementcost() * 1.05);
        rent.setRents(user1);
        rent.setPlacementfk(placement1);
        rentService.save(rent);
        return "redirect:/placements-all";
    }

    @GetMapping("/placement-delete/{id}")
    public String deletePlacement(
            @PathVariable int id) {
        Placement placement = placementService.findById(id);
        placementService.delete(placement);
        return "redirect:/placements-all";
    }

    @GetMapping("/rent-delete/{id}")
    public String deleteRent(
            @PathVariable int id) {
        rentService.delete(id);
        return "redirect:/placements-all";
    }

    @GetMapping("/room-delete/{id}")
    public String deleteRoom(
            @PathVariable int id) {
        Room room = roomService.findById(id);
        roomService.delete(room);
        return "redirect:/placements-all";
    }


    @GetMapping("/placement-update/{id}")
    public String updatePlacementGet(
            @PathVariable int id,
            Placement placement,
            Room room,
            Model model
    ) {
        placement = placementService.findById(id);
        List<Room> rooms = roomService.findAll();
        Placement placement1 = placementService.findById(id);
        model.addAttribute("places", placement);
        model.addAttribute("rooms", rooms);
        model.addAttribute("placement", placement1);
        return "placement/PlacementUpdate";
    }

    @PostMapping("/placement-update/{id}")
    public String updatePlacementPost(
            @PathVariable int id,
            Placement placement,
            Room room,
            Model model
    ) {
        placementService.save(placement);
        return "redirect:/placements-all";
    }
}
