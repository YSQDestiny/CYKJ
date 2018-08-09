package com.cykj.service.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yangsq
 * @date 2018/8/3 9:21.
 */
@Entity
@Table(name = "disasters_sichuan", schema = "zhdn", catalog = "")
public class Disasters implements Serializable {
    private int id;
    private int deleteStatus;
    private int version;
    private String address;
    private String time;
    private String pattern;
    private String houseLoss;
    private String boatLoss;
    private String farmlandLoss;
    private String foodLoss;
    private String economyLoss;
    private String death;
    private String injury;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "deleteStatus")
    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Basic
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "pattern")
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Basic
    @Column(name = "house_loss")
    public String getHouseLoss() {
        return houseLoss;
    }

    public void setHouseLoss(String houseLoss) {
        this.houseLoss = houseLoss;
    }

    @Basic
    @Column(name = "boat_loss")
    public String getBoatLoss() {
        return boatLoss;
    }

    public void setBoatLoss(String boatLoss) {
        this.boatLoss = boatLoss;
    }

    @Basic
    @Column(name = "farmland_loss")
    public String getFarmlandLoss() {
        return farmlandLoss;
    }

    public void setFarmlandLoss(String farmlandLoss) {
        this.farmlandLoss = farmlandLoss;
    }

    @Basic
    @Column(name = "food_loss")
    public String getFoodLoss() {
        return foodLoss;
    }

    public void setFoodLoss(String foodLoss) {
        this.foodLoss = foodLoss;
    }

    @Basic
    @Column(name = "economy_loss")
    public String getEconomyLoss() {
        return economyLoss;
    }

    public void setEconomyLoss(String economyLoss) {
        this.economyLoss = economyLoss;
    }

    @Basic
    @Column(name = "death")
    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    @Basic
    @Column(name = "injury")
    public String getInjury() {
        return injury;
    }

    public void setInjury(String injury) {
        this.injury = injury;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disasters that = (Disasters) o;

        if (id != that.id) return false;
        if (deleteStatus != that.deleteStatus) return false;
        if (version != that.version) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (pattern != null ? !pattern.equals(that.pattern) : that.pattern != null) return false;
        if (houseLoss != null ? !houseLoss.equals(that.houseLoss) : that.houseLoss != null) return false;
        if (boatLoss != null ? !boatLoss.equals(that.boatLoss) : that.boatLoss != null) return false;
        if (farmlandLoss != null ? !farmlandLoss.equals(that.farmlandLoss) : that.farmlandLoss != null) return false;
        if (foodLoss != null ? !foodLoss.equals(that.foodLoss) : that.foodLoss != null) return false;
        if (economyLoss != null ? !economyLoss.equals(that.economyLoss) : that.economyLoss != null) return false;
        if (death != null ? !death.equals(that.death) : that.death != null) return false;
        if (injury != null ? !injury.equals(that.injury) : that.injury != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + deleteStatus;
        result = 31 * result + version;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (pattern != null ? pattern.hashCode() : 0);
        result = 31 * result + (houseLoss != null ? houseLoss.hashCode() : 0);
        result = 31 * result + (boatLoss != null ? boatLoss.hashCode() : 0);
        result = 31 * result + (farmlandLoss != null ? farmlandLoss.hashCode() : 0);
        result = 31 * result + (foodLoss != null ? foodLoss.hashCode() : 0);
        result = 31 * result + (economyLoss != null ? economyLoss.hashCode() : 0);
        result = 31 * result + (death != null ? death.hashCode() : 0);
        result = 31 * result + (injury != null ? injury.hashCode() : 0);
        return result;
    }
}
