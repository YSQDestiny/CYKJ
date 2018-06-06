package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangsq
 * @date 2018/6/6 17:15.
 */
@Entity
@Table(name = "accident", schema = "cykj", catalog = "")
public class AccidentEntity extends BaseEntity{
    private int companyId;
    private String instructions;
    private String sitePhoto;
    private String surroundingsPhoto;
    private String type;
    private String result;

    @Basic
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
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
    @Column(name = "site_photo")
    public String getSitePhoto() {
        return sitePhoto;
    }

    public void setSitePhoto(String sitePhoto) {
        this.sitePhoto = sitePhoto;
    }

    @Basic
    @Column(name = "surroundings_photo")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccidentEntity that = (AccidentEntity) o;

        if (companyId != that.companyId) return false;
        if (instructions != null ? !instructions.equals(that.instructions) : that.instructions != null) return false;
        if (sitePhoto != null ? !sitePhoto.equals(that.sitePhoto) : that.sitePhoto != null) return false;
        if (surroundingsPhoto != null ? !surroundingsPhoto.equals(that.surroundingsPhoto) : that.surroundingsPhoto != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = companyId;
        result1 = 31 * result1 + (instructions != null ? instructions.hashCode() : 0);
        result1 = 31 * result1 + (sitePhoto != null ? sitePhoto.hashCode() : 0);
        result1 = 31 * result1 + (surroundingsPhoto != null ? surroundingsPhoto.hashCode() : 0);
        result1 = 31 * result1 + (type != null ? type.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }
}
