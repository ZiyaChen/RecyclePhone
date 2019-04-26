package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.MobileTypeDAO;
import com.shichen.ihuigo.entity.MobileType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MobileTypeService {
    @Resource
    private MobileTypeDAO mobileTypeDAO;

    public List<MobileType> getAllType(){
        return mobileTypeDAO.getAllEntity(MobileType.class);
    }
}
