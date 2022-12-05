package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Placement;
import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.model.Room;
import com.ruscript.tutorialproject.service.PlacementService;
import com.ruscript.tutorialproject.service.RoomService;
import com.ruscript.tutorialproject.service.UserDetailsPrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Controller
public class PlacementController {

    public final PlacementService placementService;

    public final RoomService roomService;

    public PlacementController(PlacementService placementService, RoomService roomService) {
        this.placementService = placementService;
        this.roomService = roomService;
    }

    @Value("${upload.path}")
    private String uploadPath;

    public boolean checkRole(String role){
        UserDetailsPrincipal principal = (UserDetailsPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<Role> few = principal.user.role;
        for (Role role1:
                few) {
            if (role1.name().equals(role)){
                return true;
            }
        }
        return false;
    }

    @GetMapping("/placements-all")
    public String findAll(Model model,
                          Placement placement) {
//        try {
//            if (checkRole("ADMIN") || checkRole("RENTER")) {
                List<Placement> placements = placementService.findAll();
                List<Room> rooms = roomService.findAll();
                model.addAttribute("places", placements);
                model.addAttribute("rooms", rooms);
                return "placement/AllPlacementsView";
            }
//        } catch (Exception e) {
//        }
//        return "Error";
//    }

    @GetMapping("/placement-create")
    public String createPlacementGet(
            Placement placement,
            Model model,
            BindingResult bindingResult) {
//        try {
//            if (checkRole("ADMIN") || checkRole("RENTER")) {

                List<Placement> placements = placementService.findAll();
                List<Room> rooms = roomService.findAll();

                model.addAttribute("places", placements);
                model.addAttribute("rooms", rooms);

                return "placement/AllPlacementsView";
            }
//        }
//        catch (Exception e){}
//        return "Error";
    //}

    @PostMapping("/placement-create")
    public String createPlacementPost(
            @RequestParam int roomid,
            @Validated Placement placement,
            @Validated Room room,
            Model model,
            BindingResult bindingResult) {
//        try {
//            if (checkRole("ADMIN") || checkRole("RENTER")) {
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
//            }
//        }catch (Exception ex){}
//        return "Error";
    }

    @GetMapping("/room-create")
    public String createRoomGet(
            Placement placement,
            Room room,
            Model model) {
       // try {
        List<Placement> placements = placementService.findAll();
        List<Room> rooms = roomService.findAll();
        model.addAttribute("places", placements);
        model.addAttribute("rooms", rooms);
   //         if (checkRole("ADMIN") || checkRole("RENTER")) {
                return "placement/AllPlacementsView";
          //  }
//        }
//        catch (Exception e){}
//        return "Error";
    }

    @PostMapping("/room-create")
    public String createRoomPost(
            Placement placement,
            Room room,
            @RequestParam("file") MultipartFile file,
            Model model,
            BindingResult bindingResult) {
    //    try {
           // if (checkRole("ADMIN") || checkRole("RENTER")) {
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
                room.setRoomname(uploadPath + "/" + resultFileName);

                roomService.save(room);
                return "redirect:/placements-all";
            //}
//        }catch (Exception ex){}
//        return "Error";
    }
//
//    @GetMapping("/placement-delete/{id}")
//    public String deleteById(@PathVariable int id){
////        try {
////            if (checkRole("ADMIN") || checkRole("RENTER")) {
//                Placement placement = placementService.findById(id);
//                placementService.delete(placement);
//                return "redirect:/placements-all";
//            }
////        }catch (Exception e){}
////        return "Error";
////    }
//
//    @GetMapping("/placement-update/{id}")
//    public String update(
//            @PathVariable int id,
//            Placement placement,
//            Room room,
//            Model model
//    ){
//        try {
//            if (checkRole("ADMIN") || checkRole("RENTER")) {
//                placement = placementService.findById(id);
//                List<Room> rooms = roomService.findAll();
//                model.addAttribute("placement", placement);
//                model.addAttribute("rooms", rooms);
//                return "document/DocumentUpdate";
//            }
//        }catch (Exception e){}
//        return "Error";
//    }
//
//    @PostMapping("/placement-update/{id}")
//    public String updateString(
//            Placement placement,
//            Room room
//    ){
//        try {
//            if (checkRole("ADMIN") || checkRole("RENTER")) {
//                placementService.save(placement);
//
//                return "redirect:/documents-all";
//            }
//        }catch (Exception e){}
//        return "Error";
//    }
}
