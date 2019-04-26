package com.shichen.ihuigo.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;
@Repository
public class BaseDAO<T> {
    @Resource
    private SessionFactory sessionFactory;

    public List<T> getAllEntity(Class<T> clazz){
        return sessionFactory
                .getCurrentSession()
                .createQuery(" from "+clazz.getSimpleName(),clazz).list();
    }

    public T getEntityById(Class<T> clazz,Integer id){
        return sessionFactory.getCurrentSession()
                .get(clazz,id);
    }

    public void saveEntity(T t){
        sessionFactory.getCurrentSession().save(t);
    }

    public void deleteEntity(T t){
        sessionFactory.getCurrentSession().delete(t);
    }

    public void updateEntity(T t){
        sessionFactory.getCurrentSession().update(t);
    }
}
