package com.shichen.ihuigo.dao;

import com.shichen.ihuigo.entity.MobilePhone;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.List;

@Repository
public class MobilePhoneDAO extends BaseDAO<MobilePhone> {

    @Resource
    private SessionFactory sessionFactory;

    private static  final Integer PAGE=8;
    public List<MobilePhone> getPhoneByPage(Integer index){
        Query<MobilePhone> query = sessionFactory.getCurrentSession().createQuery("from MobilePhone", MobilePhone.class);
        query.setFirstResult((index-1)*PAGE);
        query.setMaxResults(PAGE);
        return query.list();
    }
    public List<MobilePhone> getPhoneByType(Integer index,Integer type){
        Query<MobilePhone> query = sessionFactory
                .getCurrentSession().createQuery("from MobilePhone where mobile_type_id=?", MobilePhone.class);
        query.setParameter(0,type);
        query.setFirstResult((index-1)*PAGE);
        query.setMaxResults(PAGE);
        return query.list();
    }
    public Long getPhoneCount(){
        return sessionFactory.getCurrentSession()
                .createQuery("select count(1) from MobilePhone",Long.class).uniqueResult();
    }
    public Long getPhoneCountByType(Integer id){
        return sessionFactory.getCurrentSession()
                .createQuery("select count(1) from MobilePhone where mobile_type_id=?",Long.class)
                .setParameter(0,id).uniqueResult();
    }

    public List<MobilePhone> getPhoneByName(String pName ,Integer index){
        return sessionFactory.getCurrentSession()
                .createQuery("from MobilePhone where mobile_name like :name")
                .setString("name", "%"+pName+"%")
                .setFirstResult((index-1)*PAGE)
                .setMaxResults(PAGE)
                .list();
    }
}
