package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.BasicSituationDAO;
import com.shichen.ihuigo.entity.BasicSituation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BasicSituationService {
    @Resource
    private BasicSituationDAO basicSituationDAO;
    public List<BasicSituation> getBasicById(Integer id){
        return basicSituationDAO.getBasicSituationByPhone(id);
    }
}
