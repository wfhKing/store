package com.nf147.ssm.controller;

import com.nf147.ssm.dao.InventoriesMapper;
import com.nf147.ssm.dao.PetMapper;
import com.nf147.ssm.dao.PhotoMapper;
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

    @RequestMapping(value = "/list")
    public String list(Model model){
        List<Pet> pets = petMapper.selectAll();
        model.addAttribute("pets",pets);
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody Pet pet, @RequestBody Inventories inventories) {
        petMapper.insert(pet);
        inventoriesMapper.insert(inventories);
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("输入无效");
        return "{\"msg\":\"宠物添加成功\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Pet pet) {
        petMapper.updateByPrimaryKey(pet);
        return "{\"msg\":\"修改成功\"}";
    }

    @RequestMapping(value = "/findByStatus", method = RequestMethod.GET)
    @ResponseBody
    public String findByStatus(@RequestParam("petStatus") String petStatus, Model model) {
        Pet byStatus = petMapper.findByStatus(petStatus);
        model.addAttribute("byStatus", byStatus);
        return "{\"msg\":\"根据状态查询成功\"}";
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String selectByPrimaryKey(@RequestParam("petId") int petId, Model model) {
        Pet pet = petMapper.selectByPrimaryKey(petId);
        model.addAttribute("pet", pet);
        return "{\"msg\":\"根据宠物ID查询成功\"}";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam("petId") int petId) {
        petMapper.deleteByPrimaryKey(petId);
        return "{\"msg\":\"删除成功\"}";
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public String insertImage(@RequestBody Photo photo) {
        photoMapper.insert(photo);
        return "{\"msg\":\"图片上传成功\"}";
    }

}
