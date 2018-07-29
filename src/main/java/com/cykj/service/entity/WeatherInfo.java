package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;

@Entity
public class WeatherInfo extends BaseEntity {

    private long projectId;

    private String name;

    private String highWeather;

    private String lowWeather;

    private String rainFull;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHighWeather() {
        return highWeather;
    }

    public void setHighWeather(String highWeather) {
        this.highWeather = highWeather;
    }

    public String getLowWeather() {
        return lowWeather;
    }

    public void setLowWeather(String lowWeather) {
        this.lowWeather = lowWeather;
    }

    public String getRainFull() {
        return rainFull;
    }

    public void setRainFull(String rainFull) {
        this.rainFull = rainFull;
    }
}
