package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.*;

/**
 * @author yangsq
 * @date 2018/6/7 9:44.
 */
@Entity
@Table(name = "accident")
public class AccidentEntity extends BaseEntity{

    private Long companyId;
    private String instructions;
    private String sitePhoto;
    private String surroundingsPhoto;
    private String type;
    private String result;

    @Basic
    @Column(name = "company_id")
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
    @Column(name = "sitePhoto",length = 30000)
    public String getSitePhoto() {
        return sitePhoto;
    }

    public void setSitePhoto(String sitePhoto) {
        this.sitePhoto = sitePhoto;
    }

    @Basic
    @Column(name = "surroundingsPhoto",length = 30000)
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

    @Basic
    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
