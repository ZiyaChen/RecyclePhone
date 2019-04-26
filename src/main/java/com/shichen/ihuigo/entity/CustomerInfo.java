package com.shichen.ihuigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_info")
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    @Column(name = "address_info")
    private String addressInfo;
    private String bank;
    @Column(name = "bank_card")
    private String bankCard;
    @Column(name = "bank_name")
    private String bankName;
    private Byte locked;
    private String mobile;
    @Column(name = "true_name")
    private String trueName;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", addressInfo='" + addressInfo + '\'' +
                ", bank='" + bank + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", bankName='" + bankName + '\'' +
                ", locked=" + locked +
                ", mobile='" + mobile + '\'' +
                ", trueName='" + trueName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
