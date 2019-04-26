package com.shichen.ihuigo.dao;

import com.shichen.ihuigo.entity.BasicSituation;
import com.shichen.ihuigo.entity.BasicSituationInfo;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BasicSituationInfoDAO extends BaseDAO<BasicSituationInfo> {
    @Resource
    private SessionFactory sessionFactory;

    public List<BasicSituationInfo> getBasicSituationInfoById(Integer id){
        return sessionFactory.getCurrentSession()
                .createQuery("from BasicSituationInfo where attribute_id=?",BasicSituationInfo.class)
                .setParameter(0,id)
                .list();
    }
}
