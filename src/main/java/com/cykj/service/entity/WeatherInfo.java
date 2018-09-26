package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "weatherinfo", schema = "cykj", catalog = "")
public class WeatherInfo extends BaseEntity {

    private String name;

    private String highWeather;

    private String lowWeather;

    private String rainfall;

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

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }
}
