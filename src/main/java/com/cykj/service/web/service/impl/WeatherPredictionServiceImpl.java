package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.WeatherPredictionDao;
import com.cykj.service.entity.WeatherPrediction;
import com.cykj.service.web.service.WeatherPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangsq
 * @date 2018/7/19 16:02.
 */
@Service("weatherPredictionService")
public class WeatherPredictionServiceImpl extends BaseServiceImpl<WeatherPrediction> implements WeatherPredictionService {

    @Autowired
    private WeatherPredictionDao weatherPredictionDao;

    @Override
    public WeatherPrediction findWeatherPredictionByCity(String city) {
        return weatherPredictionDao.findWeatherPredictionByCity(city);
    }
}
