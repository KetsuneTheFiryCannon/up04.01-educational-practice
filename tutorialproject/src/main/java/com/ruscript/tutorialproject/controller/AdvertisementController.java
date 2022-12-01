package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Advertisement;
import com.ruscript.tutorialproject.model.Photo;
import com.ruscript.tutorialproject.service.AdvertisementService;
import com.ruscript.tutorialproject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AdvertisementController {

    @Autowired
    private final AdvertisementService advertisementService;

    @Autowired
    private final PhotoService photoService;

    public AdvertisementController(AdvertisementService advertisementService, PhotoService photoService) {
        this.advertisementService = advertisementService;
        this.photoService = photoService;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/advertisement-create")
    public String advertisementCreateGet(
            Model model){

        List<Advertisement> advertisements = advertisementService.findAll();
        List<Photo> photos = photoService.findAll();

        model.addAttribute("advertisements", advertisements);
        model.addAttribute("photos", photos);

        return "advertisement/AdvertisementCreate";
    }

    @PostMapping("/advertisement-create")
    public String advertisementCreatePost(
            @RequestParam int advertisement,
            @RequestParam int photo
//            ,
//            @RequestParam("file") MultipartFile file
    ) {
//        if (file != null) {
//            File uploadDir = new File(uploadPath);
//            if(!uploadDir.exists()){
//                uploadDir.mkdir();
//            }
//        }
//
//        String uuid = UUID.randomUUID().toString();
//        String resultFileName = uuid + "." + file.getOriginalFilename();
//        try {
//            file.transferTo(new File(uploadPath + "/" + resultFileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Advertisement advertisement1 = advertisementService.findByNameAdvertisementid(advertisement);
        Photo photo1 = photoService.findByPhotoid(photo);

        //photo1.setPhotopath(uploadPath + "/" + resultFileName);

        advertisement1.getPhotos().add(photo1);

        advertisementService.save(advertisement1);

        return "redirect:/home";
    }
}

