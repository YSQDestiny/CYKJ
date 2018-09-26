package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author yangsq
 * @date 2018/9/26 15:03.
 */
@Entity
@Table(name = "property_accident", schema = "cykj", catalog = "")
public class PropertyAccident extends BaseEntity {

    //企业ID
    private Long propertyId;
    //风险点说明
    private String instructions;
    //事故后果
    private String result;
    //风险点照片
    private String sitePhoto;
    //风险环境照片
    private String surroundingsPhoto;
    //风险类型
    private String type;
    //风险等级
    private String level;
    //风险等级说明
    private String levelDes;
    //区域
    private String area;

    @Temporal(TemporalType.TIMESTAMP)
    private Date makeTime;
    //整改建议
    private String suggestion;

    private String name;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSitePhoto() {
        return sitePhoto;
    }

    public void setSitePhoto(String sitePhoto) {
        this.sitePhoto = sitePhoto;
    }

    public String getSurroundingsPhoto() {
        return surroundingsPhoto;
    }

    public void setSurroundingsPhoto(String surroundingsPhoto) {
        this.surroundingsPhoto = surroundingsPhoto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelDes() {
        return levelDes;
    }

    public void setLevelDes(String levelDes) {
        this.levelDes = levelDes;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
