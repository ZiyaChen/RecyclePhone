package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.OrdersDAO;
import com.shichen.ihuigo.entity.BasicSituationInfo;
import com.shichen.ihuigo.entity.Price;
import com.shichen.ihuigo.entity.WearDegreeInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShowPriceService {
    @Resource
    private BasicSituationInfoService basicSituationInfoService;

    @Resource
    private WearDegreeInfoService wearDegreeInfoService;

    @Resource
    private OrdersDAO ordersDAO;

    public Double getPrice(String basicsId,String wearsId,String functionalsId,Double phonePrice){
        String[] basics = basicsId.split(",");
        String[] wears = wearsId.split(",");
        String[] functionals = functionalsId.split(",");
        Double result=0d;
        for (int i=0;i<basics.length;i++){
            BasicSituationInfo b = basicSituationInfoService.getBasicInfoById(Integer.parseInt(basics[i]));
            result+=phonePrice*b.getWeights();
        }
        phonePrice=phonePrice-result;
        result=0d;
        for (int i=0;i<wears.length;i++){
            WearDegreeInfo w = wearDegreeInfoService.getWearById(Integer.parseInt(wears[i]));
            result+=phonePrice*w.getWeights();
        }
        phonePrice=phonePrice-result;
        for (int i=0;i<functionals.length;i++){
            if(Integer.parseInt(functionals[i])==8){
                phonePrice=50d;
                break;
            }
            phonePrice=phonePrice*0.9;
        }
        return phonePrice;
    }

    @Transactional
    public int getMaxPriceByPhone(Integer id){
        return ordersDAO.getMaxPriceByDay(id);
    }

    @Transactional
    public List<Price> getPriceList(Integer id){
        return ordersDAO.getPriceByMonth(id);
    }
}
