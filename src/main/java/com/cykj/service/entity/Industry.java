package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;

/**
 * @author yangsq
 * @date 2018/7/16 16:58.
 */
@Entity
public class Industry extends BaseEntity {

    private long parentId;

    private String name;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
