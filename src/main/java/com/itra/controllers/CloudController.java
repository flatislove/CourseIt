package com.itra.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.itra.service.impl.CloudinaryResourse;
import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CloudController {


    @GetMapping("/projects/:id/files")
    public ResponseEntity<List<String>> getAllFilesOfProject(
            @RequestParam(value = "name", required = false) String fileName) {
        Cloudinary cloudinary = new Cloudinary("cloudinary://" + CloudinaryResourse.api_key
                + ":" + CloudinaryResourse.api_secret + "@" + CloudinaryResourse.cloud_name);
        List<String> files = new ArrayList<>();
        try {
            Map response = cloudinary.api().resource("", ObjectUtils.asMap("type", "upload"));
            JSONObject jsonpObject = new JSONObject(response);
            JSONArray jsonArray = jsonpObject.getJSONArray("resources");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonpObject1 = jsonArray.getJSONObject(i);
                files.add(jsonpObject1.getString("url"));
            }
            return new ResponseEntity<>(files, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/project/:id/files")
    public ResponseEntity<String> uploadFileToCloud(
            @RequestParam(value = "upload", required = true) MultipartFile multipartFile) {
        Cloudinary cloudinary = new Cloudinary("cloudinary://" + CloudinaryResourse.api_key
                + ":" + CloudinaryResourse.api_secret + "@" + CloudinaryResourse.cloud_name);
        try {
            File file = Files.createTempFile("temp", multipartFile.getOriginalFilename()).toFile();
            multipartFile.transferTo(file);
            Map response = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            JSONObject jsonObject = new JSONObject(response);
            String url = jsonObject.getString("url");
            return new ResponseEntity<String>("{\"status\":\"OK\", \"url\":\"" + url + "\"}", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        }
    }
}
