package com.shichen.ihuigo.dao;

import com.shichen.ihuigo.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CustomerDAO extends BaseDAO<Customer> {
    @Resource
    private SessionFactory sessionFactory;
    public Customer getUserByName(String name){
        Query<Customer> query = sessionFactory.getCurrentSession()
                .createQuery("from Customer where cust_name=?", Customer.class);
        return query.setParameter(0,name).uniqueResult();
    }
}
