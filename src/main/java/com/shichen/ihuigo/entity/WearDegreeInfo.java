package com.shichen.ihuigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "wear_degree_info")
public class WearDegreeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String describes;
    private String detailed;
    private Double weights;
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private WearDegree wearDegree;

    @Override
    public String toString() {
        return "WearDegreeInfo{" +
                "id=" + id +
                ", describes='" + describes + '\'' +
                ", detailed='" + detailed + '\'' +
                ", weights=" + weights +
                ", wearDegree=" + wearDegree +
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

    public Double getWeights() {
        return weights;
    }

    public void setWeights(Double weights) {
        this.weights = weights;
    }

    public WearDegree getWearDegree() {
        return wearDegree;
    }

    public void setWearDegree(WearDegree wearDegree) {
        this.wearDegree = wearDegree;
    }
}
