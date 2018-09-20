package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangsq
 * @date 2018/9/19 9:13.
 */
@Entity
@Table(name = "property_area")
public class PropertyArea extends BaseEntity {

    private String name;

    private int singlePoint;

    private int important;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSinglePoint() {
        return singlePoint;
    }

    public void setSinglePoint(int singlePoint) {
        this.singlePoint = singlePoint;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }
}
