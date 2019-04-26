package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.WearDegreeDAO;
import com.shichen.ihuigo.entity.WearDegree;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class WearDegreeService {
    @Resource
    private WearDegreeDAO wearDegreeDAO;

    public List<WearDegree> getAllWearDegree(){
        return wearDegreeDAO.getAllEntity(WearDegree.class);
    }
}
