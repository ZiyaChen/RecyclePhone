package com.shichen.ihuigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "basic_situation_info")
public class BasicSituationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String describes;
    private String detailed;
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private BasicSituation basicSituation;
    private Double weights;

    @Override
    public String toString() {
        return "BasicSituationInfo{" +
                "id=" + id +
                ", describes='" + describes + '\'' +
                ", detailed='" + detailed + '\'' +
                ", basicSituation=" + basicSituation +
                ", weights=" + weights +
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

    public BasicSituation getBasicSituation() {
        return basicSituation;
    }

    public void setBasicSituation(BasicSituation basicSituation) {
        this.basicSituation = basicSituation;
    }

    public Double getWeights() {
        return weights;
    }

    public void setWeights(Double weights) {
        this.weights = weights;
    }
}
