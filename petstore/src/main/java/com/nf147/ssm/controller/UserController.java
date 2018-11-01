package com.nf147.ssm.controller;

import com.nf147.ssm.dao.UserMapper;
import com.nf147.ssm.entity.User;
import com.nf147.ssm.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @ResponseBody
    public String createWithArray(@RequestBody List<User> userList){
        userMapper.insertAll(userList);
        return "{\"msg\":\"批量添加成功\"}";
    }

    @RequestMapping(value = "/login/{userName}:{possword}",method = RequestMethod.GET)
    public String login(@PathVariable("userName") String userName, @PathVariable("possword") String possword, HttpSession session){
        User user = userMapper.getByName(userName);
        if (user!=null){
            if(user.getUserPassword()==possword){
                session.setAttribute("user",user);
                return "{\"msg\":\"登录成功\"}";
            }
        }
        return "{\"msg\":\"登录失败\"}";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "{\"msg\":\"注销\"}";
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getByName(@RequestParam("userName") String userName, Model model){
        User user = userMapper.getByName(userName);
        model.addAttribute("user",user);
        return "{\"msg\":\"根据名字查询成功\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(User user){
        userMapper.updateByPrimaryKey(user);
        return "{\"msg\":\"修改成功\"}";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteByName(@RequestParam("userName") String userName){
        userMapper.deleteByName(userName);
        return "{\"msg\":\"删除成功\"}";
    }
}
