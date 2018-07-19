package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.WeatherPrediction;

/**
 * @author yangsq
 * @date 2018/7/19 15:30.
 */
public interface WeatherPredictionDao extends BaseDao<WeatherPrediction> {

    WeatherPrediction findWeatherPredictionByCity(String city);

}
