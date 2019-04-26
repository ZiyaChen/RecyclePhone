package com.shichen.ihuigo.dao;

import com.shichen.ihuigo.entity.BasicSituation;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BasicSituationDAO extends BaseDAO<BasicSituation> {
    @Resource
    private SessionFactory sessionFactory;
    public List<BasicSituation> getBasicSituationByPhone(Integer phoneId){
        return sessionFactory.getCurrentSession()
                .createQuery("from BasicSituation where mobile_id=?",BasicSituation.class)
                .setParameter(0,phoneId)
                .list();
    }
}
