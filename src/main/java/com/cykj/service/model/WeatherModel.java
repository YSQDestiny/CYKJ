package com.cykj.service.model;

import com.cykj.service.entity.WeatherInfo;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/30 10:40.
 */
public class WeatherModel {

    private List<WeatherInfo> weatherInfoList;

    public List<WeatherInfo> getWeatherInfoList() {
        return weatherInfoList;
    }

    public void setWeatherInfoList(List<WeatherInfo> weatherInfoList) {
        this.weatherInfoList = weatherInfoList;
    }


}
