package com.nf147.ssm.controller;

import com.nf147.ssm.dao.UserMapper;
import com.nf147.ssm.entity.User;
import com.nf147.ssm.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String insert(User user){
        userMapper.insert(user);
        return "{\"msg\":\"添加成功\"}";
    }

    @RequestMapping(value = "/createWithArray",method = RequestMethod.POST)
    public String createWithArray(){
        return "";
    }

    @RequestMapping(value = "/createWithList",method = RequestMethod.POST)
    public String createWithList(){
        return "";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        return "";
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getByName(@RequestParam("userName") String userName, Model model){
        User user = userMapper.getByName(userName);
        model.addAttribute("user",user);
        return "{\"msg\":\"成功\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(User user){
        userMapper.updateByPrimaryKey(user);
        return "";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteByName(@RequestParam("userName") String userName){
        userMapper.deleteByName(userName);
        return "";
    }
}
