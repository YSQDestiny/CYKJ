package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "disaster", schema = "cykj", catalog = "")
public class Disaster extends BaseEntity {


    private String city;
    private String county;
    private String hiddenDanger;
    private String type;
    private String town;
    private String village;
    private String group;
    private int threatProperty;
    private int threatHouseholds;
    private int threatPeople;
    private String isPlan;
    private String isIssue;
    private String isBuild;

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "county")
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Basic
    @Column(name = "hidden_danger")
    public String getHiddenDanger() {
        return hiddenDanger;
    }

    public void setHiddenDanger(String hiddenDanger) {
        this.hiddenDanger = hiddenDanger;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "town")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Basic
    @Column(name = "village")
    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    @Basic
    @Column(name = "group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Basic
    @Column(name = "threat_property")
    public int getThreatProperty() {
        return threatProperty;
    }

    public void setThreatProperty(int threatProperty) {
        this.threatProperty = threatProperty;
    }

    @Basic
    @Column(name = "threat_households")
    public int getThreatHouseholds() {
        return threatHouseholds;
    }

    public void setThreatHouseholds(int threatHouseholds) {
        this.threatHouseholds = threatHouseholds;
    }

    @Basic
    @Column(name = "threat_people")
    public int getThreatPeople() {
        return threatPeople;
    }

    public void setThreatPeople(int threatPeople) {
        this.threatPeople = threatPeople;
    }

    @Basic
    @Column(name = "isPlan")
    public String getIsPlan() {
        return isPlan;
    }

    public void setIsPlan(String isPlan) {
        this.isPlan = isPlan;
    }

    @Basic
    @Column(name = "isIssue")
    public String getIsIssue() {
        return isIssue;
    }

    public void setIsIssue(String isIssue) {
        this.isIssue = isIssue;
    }

    @Basic
    @Column(name = "isBuild")
    public String getIsBuild() {
        return isBuild;
    }

    public void setIsBuild(String isBuild) {
        this.isBuild = isBuild;
    }

}
