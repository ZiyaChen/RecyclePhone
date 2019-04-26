package com.shichen.ihuigo.dao;

import com.shichen.ihuigo.entity.Orders;
import com.shichen.ihuigo.entity.Price;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersDAO extends BaseDAO<Orders>{
    @Resource
    private SessionFactory sessionFactory;

    public int getMaxPriceByDay(Integer phoneId){
        String sql="SELECT MAX(price) FROM orders WHERE mobile_id = "+phoneId+" AND start_time > date_format(date_sub(NOW(), interval 30 day),'%Y-%m-%d')";
        Object o = sessionFactory
                .getCurrentSession()
                .createNativeQuery(sql).uniqueResult();
        if(o==""||o==null){
            return 0;
        }
        return (Integer)o;
    }
    public List<Price> getPriceByMonth(Integer id){
        String sql="SELECT date_format(start_time,'%Y-%m') as df, AVG(price) as p FROM orders WHERE mobile_id = "+id+" AND start_time > date_format(date_sub(NOW(), interval 4 MONTH),'%Y-%m') GROUP BY df";
        List<Object[]> resultList = sessionFactory
                .getCurrentSession().createNativeQuery(sql)
                .getResultList();
        List<Price> list=new ArrayList<>();
        for(Object[] o:resultList){
            Price price=new Price();
            price.setDate(o[0].toString());
            price.setPrice((int)Double.parseDouble(o[1].toString()));
            list.add(price);
        }
        return list;
    }
    public Orders getOrderByNumber(String num){
        return sessionFactory.getCurrentSession()
                .createQuery( " from orders where order_number=? ",Orders.class)
                .setParameter(1,num)
                .uniqueResult();
    }
    public List<Orders> getOrdersByCustId(Integer id){
        return sessionFactory.getCurrentSession()
                .createQuery("from Orders where cust_id=?",Orders.class)
                .setParameter(0,id)
                .list();
    }
    public List<Orders> getOrdersByState(String state ,Integer id){
        return sessionFactory.getCurrentSession()
                .createQuery("from Orders where order_state=? and cust_id=? ",Orders.class)
                .setParameter(0,state)
                .setParameter(1,id)
                .list();
    }

}
