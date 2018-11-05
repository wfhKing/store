package com.nf147.ssm.controller;

import com.nf147.ssm.dao.CategoryMapper;
import com.nf147.ssm.dao.InventoriesMapper;
import com.nf147.ssm.dao.PetMapper;
import com.nf147.ssm.dao.PhotoMapper;
import com.nf147.ssm.entity.Category;
import com.nf147.ssm.entity.Inventories;
import com.nf147.ssm.entity.Pet;
import com.nf147.ssm.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private InventoriesMapper inventoriesMapper;

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<Pet> pets = petMapper.selectAll();
        model.addAttribute("pets", pets);
        List<Category> categories = categoryMapper.selectAll();
        model.addAttribute("categories", categories);
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
//    public String insert(@RequestBody Pet pet, @RequestBody Inventories inventories) {
    public String insert(Pet pet) {
        petMapper.insert(pet);
//        inventoriesMapper.insert(inventories);
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("输入无效");
//        return "{\"msg\":\"宠物添加成功\"}";
        return "redirect:/pet/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Pet pet) {
        Photo photo = photoMapper.selectByPrimaryKey(pet.getPetId());
        System.out.println(photo);
        petMapper.updateByPrimaryKey(pet);
        return "redirect:/pet/list";
    }

    @RequestMapping(value = "/findByStatus", method = RequestMethod.GET)
    @ResponseBody
    public String findByStatus(@RequestParam("petStatus") String petStatus, Model model) {
        Pet byStatus = petMapper.findByStatus(petStatus);
        model.addAttribute("byStatus", byStatus);
        return "{\"msg\":\"根据状态查询成功\"}";
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public String selectByPrimaryKey(int petId, Model model) {
        Pet pet = petMapper.selectByPrimaryKey(petId);
        model.addAttribute("pet", pet);
        List<Category> categories = categoryMapper.selectAll();
        model.addAttribute("categories", categories);
//        return "{\"msg\":\"根据宠物ID查询成功\"}";
        return "petUpdate";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int petId) {
        petMapper.deleteByPrimaryKey(petId);
        return "redirect:/pet/list";
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public String insertImage(Photo photo) {
        photoMapper.insert(photo);
        return "";
    }

}
