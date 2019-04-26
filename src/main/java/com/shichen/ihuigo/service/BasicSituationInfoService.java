package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.BasicSituationInfoDAO;
import com.shichen.ihuigo.entity.BasicSituationInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BasicSituationInfoService {
    @Resource
    private BasicSituationInfoDAO basicSituationInfoDAO;

    public BasicSituationInfo getBasicInfoById(Integer id){
       return basicSituationInfoDAO.getEntityById(BasicSituationInfo.class,id);
    }

    public List<BasicSituationInfo> getAllBasicInfo(){
        return basicSituationInfoDAO.getAllEntity(BasicSituationInfo.class);
    }
}
