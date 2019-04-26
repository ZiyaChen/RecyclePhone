package com.shichen.ihuigo.controller;

import com.shichen.ihuigo.entity.MobilePhone;
import com.shichen.ihuigo.entity.MobileType;
import com.shichen.ihuigo.service.MobilePhoneService;
import com.shichen.ihuigo.service.MobileTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/phone")
@Controller
public class PhoneController {
    @Resource
    private MobilePhoneService mobilePhoneService;

    @Resource
    private MobileTypeService mobileTypeService;

    @RequestMapping("/phoneList/{pageNo}/{typeId}")
    public String getPhoneList(@PathVariable("pageNo") Integer pageNo,
                               @PathVariable("typeId") Integer typeId,Model model){
        List<MobilePhone> pList=null;
        Long pCount=0L;
        List<MobileType> ptList = mobileTypeService.getAllType();
        if(typeId==0){
            pList = mobilePhoneService.getPhoneByPage(pageNo);
            pCount = mobilePhoneService.getPhoneCount();
        }else {
            pList=mobilePhoneService.getPhoneByType(pageNo,typeId);
            pCount=mobilePhoneService.getPhoneCountByType(typeId);
        }
        Long pageCount=0L;
        if(pCount%8>0){
            pageCount=pCount/8+1;
        }else {
            pageCount=pCount/8;
        }
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pList",pList);
        model.addAttribute("pCount",pCount);
        model.addAttribute("typeId",typeId);
        model.addAttribute("ptList",ptList);
        return "index";
    }
    @ResponseBody
    @RequestMapping("/pJsonList/{pageNo}/{typeId}")
    public List<MobilePhone> getPhoneJsonList(@PathVariable("pageNo") Integer pageNo,
                                              @PathVariable("typeId") Integer typeId){
        List<MobilePhone> pList=null;
        if(typeId==0){
            pList = mobilePhoneService.getPhoneByPage(pageNo);
        }else {
            pList=mobilePhoneService.getPhoneByType(pageNo,typeId);
        }
        return pList;
    }

    @ResponseBody
    @RequestMapping("/pSearchList/{pName}/{pageNo}")
    public List<MobilePhone> getPhoneByName(@PathVariable("pName") String pName
            ,@PathVariable("pageNo") Integer pageNo){
        List<MobilePhone> list = mobilePhoneService.getPhoneByName(pName,pageNo);
        return list;
    }
}
