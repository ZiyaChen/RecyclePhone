package com.shichen.ihuigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "basic_situation")
public class BasicSituation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String attribute;
    @ManyToOne
    @JoinColumn(name = "mobile_id")
    private MobilePhone mobilePhone;

    @Override
    public String toString() {
        return "BasicSituation{" +
                "id=" + id +
                ", attribute='" + attribute + '\'' +
                ", mobilePhone=" + mobilePhone +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public MobilePhone getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
