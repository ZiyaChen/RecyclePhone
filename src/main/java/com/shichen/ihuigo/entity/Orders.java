package com.shichen.ihuigo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "basic_situation")
    private String basicSituation;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "functional_situation")
    private String functionalSituation;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "order_state")
    private String orderState;
    private int price;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "wear_degree")
    private String wearDegree;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "mobile_id")
    private MobilePhone mobile;

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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFunctionalSituation() {
        return functionalSituation;
    }

    public void setFunctionalSituation(String functionalSituation) {
        this.functionalSituation = functionalSituation;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", basicSituation='" + basicSituation + '\'' +
                ", endTime=" + endTime +
                ", functionalSituation='" + functionalSituation + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderState='" + orderState + '\'' +
                ", price=" + price +
                ", startTime=" + startTime +
                ", userName='" + userName + '\'' +
                ", wearDegree='" + wearDegree + '\'' +
                ", customer=" + customer +
                ", mobile=" + mobile +
                '}';
    }
}
