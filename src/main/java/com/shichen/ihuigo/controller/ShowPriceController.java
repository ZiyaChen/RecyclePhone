package com.shichen.ihuigo.controller;

import com.shichen.ihuigo.entity.Customer;
import com.shichen.ihuigo.entity.MobilePhone;
import com.shichen.ihuigo.entity.Orders;
import com.shichen.ihuigo.entity.ShoppingCart;
import com.shichen.ihuigo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/showPrice")
public class ShowPriceController {
    @Resource
    private MobilePhoneService mobilePhoneService;
    @Resource
    private ShowPriceService showPriceService;
    @Resource
    private ShoppingCartService shoppingCartService;

    @Resource
    private CustomerService customerService;

    @Resource
    private OrderService orderService;


    @RequestMapping("/phonePrice/{basicsId}/{wearsId}/{functionalsId}/{phoneid}")
    public String getPrice(@PathVariable("basicsId") String basicsId,
                           @PathVariable("wearsId") String wearsId,
                           @PathVariable("functionalsId") String functionalsId,
                           @PathVariable("phoneid") Integer phoneid,
                           Model model
    ){

        MobilePhone phone = mobilePhoneService.getPhoneById(phoneid);
        double phonePrice= phone.getPrice();
        phonePrice=showPriceService.getPrice(basicsId, wearsId, functionalsId, phonePrice);
        ShoppingCart shoppingCart = shoppingCartService.createCart(basicsId, wearsId, functionalsId, phone, (int) phonePrice);
        shoppingCartService.saveCart(shoppingCart);
        model.addAttribute("phonePrice",(int)phonePrice);
        model.addAttribute("phone",phone);
        model.addAttribute("shoppingCart",shoppingCart);
        return "price";
    }
    @ResponseBody
    @RequestMapping("/saveGoods/{carId}/{userId}")
    public Orders saveGoodsInCart(@PathVariable("carId") Integer carId,@PathVariable("userId") Integer userId){
        Customer cust=null;
        ShoppingCart cart = shoppingCartService.getCartById(carId);
        Orders order=null;
        if(userId==0){
            order = orderService.addList(cart);
        }else {
            cust = customerService.getCustById(userId);
            cart = shoppingCartService.getCartById(carId);
            cart.setCustomer(cust);
            order = orderService.addList(cart);
            orderService.saveOrder(order);
        }
        return order;
    }

    @ResponseBody
    @RequestMapping("/loadDataCart")
    public List<Orders> getShoppingCart(){
            return orderService.getOrderList();
    }
    @ResponseBody
    @RequestMapping("/deleteOrder/{orderNum}")
    public String deleteOrder(@PathVariable("orderNum") String orderNum){
        List<Orders> list = orderService.getOrderList();
        for (Orders o:list){
            if(o.getOrderNumber().equals(orderNum)){
                //从缓存中删除订单
                list.remove(o);
                //当用户不为空，从数据库删除订单
                if(o.getCustomer()!=null){
                    orderService.deleteOrders(o);
                }
                return "success";
            }
        }
        return "fail";
    }
}
