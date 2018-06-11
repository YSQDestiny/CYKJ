package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangsq
 * @date 2018/6/11 10:44.
 */
@Entity
@Table(name = "accident", schema = "cykj", catalog = "")
public class AccidentEntity extends BaseEntity{

    private Long companyId;
    private String instructions;
    private String result;
    private String sitePhoto;
    private String surroundingsPhoto;
    private String type;

    @Basic
    @Column(name = "companyId")
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "instructions")
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Basic
    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "sitePhoto")
    public String getSitePhoto() {
        return sitePhoto;
    }

    public void setSitePhoto(String sitePhoto) {
        this.sitePhoto = sitePhoto;
    }

    @Basic
    @Column(name = "surroundingsPhoto")
    public String getSurroundingsPhoto() {
        return surroundingsPhoto;
    }

    public void setSurroundingsPhoto(String surroundingsPhoto) {
        this.surroundingsPhoto = surroundingsPhoto;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
