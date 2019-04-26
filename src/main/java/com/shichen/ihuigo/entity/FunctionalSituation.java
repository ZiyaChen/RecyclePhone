package com.shichen.ihuigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "functional_situation")
public class FunctionalSituation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String describes;
    private String detailed;
    @ManyToOne
    @JoinColumn(name = "mobile_id")
    private MobilePhone mobilePhone;

    @Override
    public String toString() {
        return "FunctionalSituation{" +
                "id=" + id +
                ", describes='" + describes + '\'' +
                ", detailed='" + detailed + '\'' +
                ", mobilePhone=" + mobilePhone +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public MobilePhone getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
