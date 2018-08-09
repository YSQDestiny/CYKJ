package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangsq
 * @date 2018/8/3 11:06.
 */
@Entity
@Table(name = "project_accident", schema = "cykj", catalog = "")
public class ProjectAccident extends BaseEntity {

    private String name;

    //风险点说明
    private String instructions;

    //类型
    private String type;

    //建议
    private String suggestion;

    //风险点照片
    private String sitePhoto;
    //风险环境照片
    private String surroundingsPhoto;

    private Long projectId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
