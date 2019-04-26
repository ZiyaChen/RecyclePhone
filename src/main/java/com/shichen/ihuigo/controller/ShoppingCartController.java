package com.shichen.ihuigo.controller;

import com.shichen.ihuigo.entity.Orders;
import com.shichen.ihuigo.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/cartInfo/{custId}")
    public String getCartInfo(@PathVariable("custId")Integer id, Model model){
        String state="未提交";
        List<Orders> list = orderService.getOrderListByState(state, id);
        int result=0;
        int count=0;
        for (Orders o:list){
            result+=o.getPrice();
            count++;
        }
        model.addAttribute("orderList",list);
        model.addAttribute("result",result);
        model.addAttribute("count",count);
        return "cart";
    }
}
