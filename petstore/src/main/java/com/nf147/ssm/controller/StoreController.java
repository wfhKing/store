package com.nf147.ssm.controller;

import com.nf147.ssm.dao.InventoriesMapper;
import com.nf147.ssm.dao.OrderMapper;
import com.nf147.ssm.dao.PetMapper;
import com.nf147.ssm.entity.Inventories;
import com.nf147.ssm.entity.Order;
import com.nf147.ssm.entity.Pet;
import com.nf147.ssm.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.awt.ModalExclude;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private InventoriesMapper inventoriesMapper;

    @Autowired
    private PetMapper petMapper;

    @RequestMapping(value = "/inventory",method = RequestMethod.GET)
    @ResponseBody
    public String inventory(@RequestBody Inventories inventories,@RequestBody Pet pet){
        inventoriesMapper.returnInventories(inventories);
        petMapper.updatePetStatus(pet);
//        inventoriesMapper.insert(inventories);
        return "{\"msg\":\"放入仓库成功\"}";
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    @ResponseBody
    public String insert(Order order){
        orderMapper.insert(order);
        return "{\"msg\":\"添加订单成功\"}";
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    @ResponseBody
    public String getOrderById(@RequestParam("orderId") int orderId, Model model){
        Order order = orderMapper.selectByPrimaryKey(orderId);
        model.addAttribute("order",order);
        return "{\"msg\":\"根据订单ID查询成功\"}";
    }

    @RequestMapping(value = "/order",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam("orderId") int orderId){
        orderMapper.deleteByPrimaryKey(orderId);
        return "{\"msg\":\"删除成功\"}";
    }

}
