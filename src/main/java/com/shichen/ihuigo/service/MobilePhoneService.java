package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.MobilePhoneDAO;
import com.shichen.ihuigo.entity.MobilePhone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MobilePhoneService {
    @Resource
    private MobilePhoneDAO mobilePhoneDAO;
    /*
    *获取所有手机
     */
    public List<MobilePhone> getAllPhone(){
        return mobilePhoneDAO.getAllEntity(MobilePhone.class);
    }
    /*
    获得当前页码的手机集合
     */
    public List<MobilePhone> getPhoneByPage(Integer page){
        return mobilePhoneDAO.getPhoneByPage(page);
    }
    /*
    获取此类型页码的手机集合
     */
    public List<MobilePhone> getPhoneByType(Integer page,Integer type){
        return mobilePhoneDAO.getPhoneByType(page,type);
    }
    /*
    获取所有手机数量
     */
    public Long getPhoneCount(){
        return  mobilePhoneDAO.getPhoneCount();
    }
    /*
    获得该类型手机数量
     */
    public Long getPhoneCountByType(Integer type){
        return mobilePhoneDAO.getPhoneCountByType(type);
    }

    /*
    通过模糊查询获取手机集合
     */
    public List<MobilePhone> getPhoneByName(String pName,Integer index){
        pName=pName.toLowerCase();
        return mobilePhoneDAO.getPhoneByName(pName,index);
    }
    public MobilePhone getPhoneById(Integer id){
        return mobilePhoneDAO.getEntityById(MobilePhone.class,id);
    }
}
