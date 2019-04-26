package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.CustomerDAO;
import com.shichen.ihuigo.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CustomerService {
    @Resource
    private CustomerDAO customerDAO;
    public Customer getCustById(Integer id){
        return customerDAO.getEntityById(Customer.class,id);
    }
    public Customer getCustByName(String name){
        return customerDAO.getUserByName(name);
    }

    public boolean checker(String accountNumber, String password) {
        Customer user =customerDAO.getUserByName(accountNumber);
        if(user.getCustPwd().equals(password)){
            return true;
        }
        return false;
    }
}
