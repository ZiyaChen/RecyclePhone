package com.shichen.ihuigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "mobile_type")
public class MobileType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_name")
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "MobileType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
