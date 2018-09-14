package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.WeatherInfoDao;
import com.cykj.service.entity.WeatherInfo;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/30 10:46.
 */
@Repository("weatherInfoDao")
public class WeatherInfoDaoImpl extends BaseDaoImpl<WeatherInfo> implements WeatherInfoDao {


    @Override
    public void saveWeatherInfos(List<WeatherInfo> weatherInfoList) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        for (WeatherInfo weatherInfo : weatherInfoList){
            WeatherInfo temp = findWeatherInfoByName(weatherInfo.getName());
            if (temp == null){
                getCurrentSession().save(weatherInfo);
            }
        }
    }

    @Override
    public WeatherInfo findWeatherInfoByName(String name) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from WeatherInfo where name= :name";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("name",name);
        List<WeatherInfo> weatherInfoList = query.list();
        if (weatherInfoList == null || weatherInfoList.size() == 0){
            return null;
        }
        return weatherInfoList.get(0);
    }
}
