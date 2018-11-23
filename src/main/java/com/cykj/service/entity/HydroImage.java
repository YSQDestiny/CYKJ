package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangsq
 * @date 2018/11/22 15:01.
 */
@Entity
@Table(name = "hydro_image", schema = "cykj")
public class HydroImage extends BaseEntity {

    private String name;

    private String img;

    private long hydroID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getHydroID() {
        return hydroID;
    }

    public void setHydroID(long hydroID) {
        this.hydroID = hydroID;
    }
}
