package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.FunctionalSituationDAO;
import com.shichen.ihuigo.entity.FunctionalSituation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FunctionalSituationService {
    @Resource
    private FunctionalSituationDAO functionalSituationDAO;

    public List<FunctionalSituation> getFunctionalListByPhone(Integer id){
        return functionalSituationDAO.getFunctionalByPhone(id);
    }
    public  FunctionalSituation getFunctionalById(Integer id){
        return  functionalSituationDAO.getEntityById(FunctionalSituation.class,id);
    }
}
