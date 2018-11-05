package com.nf147.ssm.controller;

import com.nf147.ssm.dao.PhotoMapper;
import com.nf147.ssm.entity.Pet;
import com.nf147.ssm.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class PhotoController {

    @Autowired
    private PhotoMapper photoMapper;

    @RequestMapping("/photo/{photoId}")
    public String getPhotoById(@PathVariable("photoId") int id, Model model) {
//        Photo photo = photoMapper.selectByPrimaryKey(id);
        List<Photo> photos = photoMapper.getPhotoByPetId(id);
        model.addAttribute("photos", photos);
        return "imageList";
    }

    @RequestMapping(value = "/photo/insertImg", method = RequestMethod.POST)
    public String insert(MultipartFile photoName, Model model, HttpServletRequest request,Pet pet) {
        String originalFilename = photoName.getOriginalFilename();
        Photo photo = new Photo();
        photo.setPhotoName(originalFilename);
        photo.setPetId(pet.getPetId());
        photoMapper.insert(photo);
        List<Photo> photos = photoMapper.getPhotoByPetId(pet.getPetId());
        model.addAttribute("photos", photos);
        try {
            photoName.transferTo(new File("E:/Study/maven/store/petstore/src/main/webapp/images/" + originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(originalFilename);
        return "imageList";
    }
}
