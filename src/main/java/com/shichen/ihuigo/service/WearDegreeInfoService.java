package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.WearDegreeInfoDAO;
import com.shichen.ihuigo.entity.WearDegreeInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class WearDegreeInfoService {
    @Resource
    private WearDegreeInfoDAO wearDegreeInfoDAO;
    public List<WearDegreeInfo> getAllWearDegreeInfo(){
        return wearDegreeInfoDAO.getAllEntity(WearDegreeInfo.class);
    }

    public WearDegreeInfo getWearById(Integer id){
        return wearDegreeInfoDAO.getEntityById(WearDegreeInfo.class,id);
    }
}
