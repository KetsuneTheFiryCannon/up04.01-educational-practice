package com.ruscript.tutorialproject.controller;

import com.ruscript.tutorialproject.model.Advertisement;
import com.ruscript.tutorialproject.model.Photo;
import com.ruscript.tutorialproject.service.AdvertisementService;
import com.ruscript.tutorialproject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
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

    @PostMapping("/advertisement-create")
    public String advertisementCreate(@ModelAttribute("advertisement") @Valid Advertisement advertisement,
                                      @ModelAttribute("photo") @Valid Photo photo,
                                      BindingResult bindingResult,
                                      @RequestParam("file") MultipartFile file) {
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
        }

        String uuid = UUID.randomUUID().toString();
        String resultFileName = uuid + "." + file.getOriginalFilename();
        try {
            file.transferTo(new File(uploadPath + "/" + resultFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
            photo.setPhotopath(resultFileName);
        photoService.save(photo);
        return "redirect:/home";
    }
}

