package com.shichen.ihuigo.controller;

import com.shichen.ihuigo.entity.*;
import com.shichen.ihuigo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/phoneInfo")
public class PhoneInfoController {
    @Resource
    private MobilePhoneService mobilePhoneService;
    @Resource
    private FunctionalSituationService functionalSituationService;
    @Resource
    private BasicSituationService basicSituationService;
    @Resource
    private BasicSituationInfoService basicSituationInfoService;
    @Resource
    private WearDegreeService wearDegreeService;
    @Resource
    private WearDegreeInfoService wearDegreeInfoService;

    @Resource
    private ShowPriceService showPriceService;
    @RequestMapping("/mobileInfo/{mobileId}")
    public String getInfoList(@PathVariable("mobileId") Integer id, Model model){
        MobilePhone phone = mobilePhoneService.getPhoneById(id);
        List<FunctionalSituation> functionalList = functionalSituationService.getFunctionalListByPhone(id);
        List<BasicSituation> basicList = basicSituationService.getBasicById(id);
        List<WearDegree> WearDegreeList = wearDegreeService.getAllWearDegree();
        List<BasicSituationInfo> BasicInfoList = basicSituationInfoService.getAllBasicInfo();
        List<WearDegreeInfo> wearDegreeInfoList = wearDegreeInfoService.getAllWearDegreeInfo();
        Integer maxPrice = showPriceService.getMaxPriceByPhone(id);
        List<Price> priceList = showPriceService.getPriceList(id);
        model.addAttribute("maxPrice",maxPrice);
        model.addAttribute("priceList",priceList);
        model.addAttribute("phone",phone);
        model.addAttribute("functionalList",functionalList);
        model.addAttribute("basicList",basicList);
        model.addAttribute("WearDegreeList",WearDegreeList);
        model.addAttribute("BasicInfoList",BasicInfoList);
        model.addAttribute("wearDegreeInfoList",wearDegreeInfoList);
        return "info";
    }
    @ResponseBody
    @RequestMapping("/basicInfo/{basicId}")
    public BasicSituationInfo getBasicInfoById(@PathVariable("basicId") Integer id){
        return basicSituationInfoService.getBasicInfoById(id);
    }
    @ResponseBody
    @RequestMapping("/wearDegreeInfo/{wearId}")
    public Double getWearInfoById(@PathVariable("wearId") Integer id){
        return wearDegreeInfoService.getWearById(id).getWeights();
    }

}
