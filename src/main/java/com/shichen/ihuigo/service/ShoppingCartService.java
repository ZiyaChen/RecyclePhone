package com.shichen.ihuigo.service;

import com.shichen.ihuigo.dao.ShoppingCartDAO;
import com.shichen.ihuigo.entity.MobilePhone;
import com.shichen.ihuigo.entity.ShoppingCart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ShoppingCartService {

    @Resource
    private BasicSituationInfoService basicSituationInfoService;

    @Resource
    private FunctionalSituationService functionalSituationService;

    @Resource
    private WearDegreeInfoService wearDegreeInfoService;

    @Resource
    private ShoppingCartDAO shoppingCartDAO;


    public ShoppingCart createCart(String basicsId
            , String wearsId, String functionalsId, MobilePhone mobilePhone,int price){
        String[] basics = basicsId.split(",");
        String[] wears = wearsId.split(",");
        String[] functionals = functionalsId.split(",");
        StringBuilder sb=new StringBuilder(50);
        ShoppingCart shoppingCart=new ShoppingCart();
        for (int i=0;i<basics.length;i++){
            sb.append(basicSituationInfoService
                    .getBasicInfoById(Integer.parseInt(basics[i])).getDescribes());
            sb.append("|");
        }
        shoppingCart.setBasicSituation(sb.toString());
        sb.delete(0,sb.length());
        for (int i=0;i<wears.length;i++){
            sb.append(wearDegreeInfoService
                    .getWearById(Integer.parseInt(wears[i])).getDescribes());
            sb.append("|");
        }
        shoppingCart.setWearDegree(sb.toString());
        sb.delete(0,sb.length());
        for (int i=0;i<functionals.length;i++){
            sb.append(functionalSituationService
                    .getFunctionalById(Integer.parseInt(functionals[i])).getDescribes());
            sb.append("|");
        }
        shoppingCart.setFunctionalSituation(sb.toString());
        shoppingCart.setMobile(mobilePhone);
        shoppingCart.setPrice(price);
        return shoppingCart;
    }
    @Transactional
    public void saveCart(ShoppingCart car){
        shoppingCartDAO.saveEntity(car);
    }
    @Transactional
    public ShoppingCart getCartById(Integer id){
        return shoppingCartDAO.getEntityById(ShoppingCart.class,id);
    }





}
