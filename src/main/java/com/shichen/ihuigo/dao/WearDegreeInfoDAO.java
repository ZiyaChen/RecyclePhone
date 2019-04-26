package com.shichen.ihuigo.dao;

import com.shichen.ihuigo.entity.BasicSituationInfo;
import com.shichen.ihuigo.entity.WearDegreeInfo;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class WearDegreeInfoDAO extends BaseDAO<WearDegreeInfo> {
    @Resource
    private SessionFactory sessionFactory;
    public List<WearDegreeInfo> getInfoById(Integer id){
        return sessionFactory.getCurrentSession()
                .createQuery("from WearDegreeInfo where attribute_id=?",WearDegreeInfo.class)
                .setParameter(0,id)
                .list();
    }
}
