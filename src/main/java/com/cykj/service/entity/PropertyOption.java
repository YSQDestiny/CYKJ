package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangsq
 * @date 2018/9/19 9:09.
 */
@Entity
@Table(name = "property_option")
public class PropertyOption extends BaseEntity {

    private String name;

    private String area;

    private String point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
