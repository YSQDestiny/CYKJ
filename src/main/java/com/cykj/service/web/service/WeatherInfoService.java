package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.WeatherInfo;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/30 10:59.
 */
public interface WeatherInfoService extends BaseService<WeatherInfo> {

    void saveWeatherInfos(List<WeatherInfo> weatherInfoList, Long projectId);

    List<WeatherInfo> findWeatherInfoByProjectId(Long projectId);

}
