package com.shichen.ihuigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "basic_situation")
    private String basicSituation;

    @Column(name = "functional_situation")
    private String functionalSituation;
    private int price;
    @Column(name = "wear_degree")
    private String wearDegree;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "mobile_id")
    private  MobilePhone mobile;

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", basicSituation='" + basicSituation + '\'' +
                ", functionalSituation='" + functionalSituation + '\'' +
                ", price=" + price +
                ", wearDegree='" + wearDegree + '\'' +
                ", customer=" + customer +
                ", mobile=" + mobile +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBasicSituation() {
        return basicSituation;
    }

    public void setBasicSituation(String basicSituation) {
        this.basicSituation = basicSituation;
    }

    public String getFunctionalSituation() {
        return functionalSituation;
    }

    public void setFunctionalSituation(String functionalSituation) {
        this.functionalSituation = functionalSituation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getWearDegree() {
        return wearDegree;
    }

    public void setWearDegree(String wearDegree) {
        this.wearDegree = wearDegree;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MobilePhone getMobile() {
        return mobile;
    }

    public void setMobile(MobilePhone mobile) {
        this.mobile = mobile;
    }
}
