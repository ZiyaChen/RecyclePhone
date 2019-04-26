package com.shichen.ihuigo.dao;


import com.shichen.ihuigo.entity.FunctionalSituation;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;

@Repository
public class FunctionalSituationDAO extends BaseDAO<FunctionalSituation> {
    @Resource
    private SessionFactory sessionFactory;

    public List<FunctionalSituation> getFunctionalByPhone(Integer phoneId){
        return sessionFactory.getCurrentSession()
                .createQuery("from FunctionalSituation where mobile_id=?",FunctionalSituation.class)
                .setParameter(0,phoneId)
                .list();
    }
}
