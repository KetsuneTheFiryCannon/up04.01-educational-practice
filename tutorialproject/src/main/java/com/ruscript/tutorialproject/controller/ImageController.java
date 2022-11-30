package com.ruscript.tutorialproject.controller;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class ImageController {
    @PostMapping("/image-uploading")
    public String uploadImage(@RequestParam("file")MultipartFile file) throws Exception{

        return "File uploaded";
    }
}

