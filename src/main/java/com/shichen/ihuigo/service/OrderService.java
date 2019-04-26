package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.OrdersDAO;
import com.shichen.ihuigo.entity.Orders;
import com.shichen.ihuigo.entity.ShoppingCart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {
    @Resource
    private OrdersDAO ordersDAO;

    private List<Orders> orderList;

    public OrderService() {
        orderList=new ArrayList<>();
    }

    public void saveOrder(Orders orders){
        ordersDAO.saveEntity(orders);
    }
    public  void deleteOrders(Orders orders){
        ordersDAO.deleteEntity(orders);
    }
    /*
    获取当前订单号的订单
     */
    public Orders getOrderByNumber(String num){
        return ordersDAO.getOrderByNumber(num);
    }
    /*
    获取该客户的所有订单
     */
    public List<Orders> getOrderByCustId(Integer id){
        return ordersDAO.getOrdersByCustId(id);
    }

    public Orders getOrdersById(Integer id){
        return ordersDAO.getEntityById(Orders.class,id);
    }

    public Orders addList(ShoppingCart cart){
        Orders order=new Orders();
        order.setBasicSituation(cart.getBasicSituation());
        order.setFunctionalSituation(cart.getFunctionalSituation());
        order.setWearDegree(cart.getWearDegree());
        order.setMobile(cart.getMobile());
        order.setPrice(cart.getPrice());
        order.setOrderState("未提交");
        order.setStartTime(new Date());
        order.setCustomer(cart.getCustomer());
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        order.setOrderNumber(uuid);
        orderList.add(order);
        return order;
    }
    /*
    缓存内的订单
     */
    public List<Orders> getOrderList(){
        return orderList;
    }
    /*
    该用户对应的订单
     */
    public List<Orders> getOrderListByCust(Integer id){
        return ordersDAO.getOrdersByCustId(id);
    }
    public List<Orders> getOrderListByState(String state,Integer custId){
        return ordersDAO.getOrdersByState(state,custId);
    }
}
