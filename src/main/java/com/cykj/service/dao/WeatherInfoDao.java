package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.WeatherInfo;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/30 10:44.
 */
public interface WeatherInfoDao extends BaseDao<WeatherInfo> {

    void saveWeatherInfos(List<WeatherInfo> weatherInfoList);

    WeatherInfo findWeatherInfoByName(String name);

}
