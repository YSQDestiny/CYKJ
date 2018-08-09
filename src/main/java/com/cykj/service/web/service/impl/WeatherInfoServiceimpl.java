package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.WeatherInfoDao;
import com.cykj.service.entity.WeatherInfo;
import com.cykj.service.web.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/30 11:03.
 */
@Service("weatherInfoService")
public class WeatherInfoServiceimpl extends BaseServiceImpl<WeatherInfo> implements WeatherInfoService {

    @Autowired
    private WeatherInfoDao weatherInfoDao;


    @Override
    public void saveWeatherInfos(List<WeatherInfo> weatherInfoList) {
        weatherInfoDao.saveWeatherInfos(weatherInfoList);
    }

    @Override
    public WeatherInfo findWeatherInfoByName(String name) {
        return weatherInfoDao.findWeatherInfoByName(name);
    }
}
