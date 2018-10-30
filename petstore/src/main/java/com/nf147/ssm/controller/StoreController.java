package com.nf147.ssm.controller;

import com.nf147.ssm.dao.OrderMapper;
import com.nf147.ssm.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.ModalExclude;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(value = "/inventory",method = RequestMethod.GET)
    public String inventory(){
        return "放入库存";
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    @ResponseBody
    public String insert(Order order){
        orderMapper.insert(order);
        return "{\"msg\":\"添加成功\"}";
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    @ResponseBody
    public String getOrderById(@RequestParam("orderId") int orderId, Model model){
        Order order = orderMapper.selectByPrimaryKey(orderId);
        model.addAttribute("order",order);
        return "{\"msg\":\"成功\"}";
    }

    @RequestMapping(value = "/order",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam("orderId") int orderId){
        orderMapper.deleteByPrimaryKey(orderId);
        return "{\"msg\":\"删除成功\"}";
    }

}
