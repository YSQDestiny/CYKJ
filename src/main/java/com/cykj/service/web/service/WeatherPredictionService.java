package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.WeatherPrediction;

/**
 * @author yangsq
 * @date 2018/7/19 16:01.
 */
public interface WeatherPredictionService extends BaseService<WeatherPrediction> {

    WeatherPrediction findWeatherPredictionByCity(String city);

}
