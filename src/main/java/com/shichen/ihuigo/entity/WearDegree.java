package com.shichen.ihuigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "wear_degree")
public class WearDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String attribute;

    @Override
    public String toString() {
        return "WearDegree{" +
                "id=" + id +
                ", attribute='" + attribute + '\'' +
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
}
