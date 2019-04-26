package com.shichen.ihuigo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mobile_phone")
public class MobilePhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String creator;
    @Column(name = "end_time")
    private Date endTime;
    private String img;
    @Column(name = "mobile_name")
    private String mobileName;
    private String modifier;
    @Column(name = "start_time")
    private Date startTime;
    @ManyToOne
    @JoinColumn(name = "mobile_type_id")
    private MobileType mobileType;
    private Double price;

    @Override
    public String toString() {
        return "MobilePhone{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", endTime=" + endTime +
                ", img='" + img + '\'' +
                ", mobileName='" + mobileName + '\'' +
                ", modifier='" + modifier + '\'' +
                ", startTime=" + startTime +
                ", mobileType=" + mobileType +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public MobileType getMobileType() {
        return mobileType;
    }

    public void setMobileType(MobileType mobileType) {
        this.mobileType = mobileType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
