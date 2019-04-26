package com.shichen.ihuigo.controller;

import com.shichen.ihuigo.entity.Customer;
import com.shichen.ihuigo.entity.Orders;
import com.shichen.ihuigo.service.CustomerService;
import com.shichen.ihuigo.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @Resource
    private OrderService orderService;
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/checker")
    public String checkerCust(@RequestParam(value = "login_username",required = false) String userName
            , @RequestParam(value = "login_password",required = false) String password
            , HttpServletRequest request, Model model){
        boolean checker = customerService.checker(userName, password);
        if(checker){
            Customer user = customerService.getCustByName(userName);
            request.getSession().setAttribute("user",user);
            List<Orders> orderList = orderService.getOrderList();
            for (Orders o:orderList){
                o.setCustomer(user);
                //将订单存入数据库
                orderService.saveOrder(o);
            }
            List<Orders> orderListByCust = orderService.getOrderListByCust(user.getId());
            for (Orders o:orderListByCust){
                orderList.add(o);
            }

            return "redirect:/phone/phoneList/1/0";
        }else {
            String msg="fail";
            model.addAttribute("failMessage",msg);
            return "login";
        }
    }
}
