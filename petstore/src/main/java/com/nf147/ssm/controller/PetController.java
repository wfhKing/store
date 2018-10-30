package com.nf147.ssm.controller;

import com.nf147.ssm.dao.PetMapper;
import com.nf147.ssm.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetMapper petMapper;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Pet> pets = petMapper.selectAll();
        model.addAttribute("pets",pets);
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String insert(Pet pet){
        petMapper.insert(pet);
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("输入无效");
        return "{\"msg\":\"添加成功\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String update(Pet pet){
        petMapper.updateByPrimaryKey(pet);
        return "{\"msg\":\"修改成功\"}";
    }

    @RequestMapping(value = "/findByStatus",method = RequestMethod.GET)
    @ResponseBody
    public String findByStatus(@RequestParam("petStatus") String petStatus,Model model){
        Pet byStatus = petMapper.findByStatus(petStatus);
        model.addAttribute("byStatus",byStatus);
        return "{\"msg\":\"成功\"}";
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String selectByPrimaryKey(@RequestParam("petId") int petId,Model model){
        Pet pet = petMapper.selectByPrimaryKey(petId);
        model.addAttribute("pet",pet);
        return "{\"msg\":\"成功\"}";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam("petId") int petId){
        petMapper.deleteByPrimaryKey(petId);
        return "{\"msg\":\"删除成功\"}";
    }

    @RequestMapping(value = "/{petId}/uploadImage",method = RequestMethod.POST)
    public String insertImage(){
        return "根据id修改图片";
    }

}
