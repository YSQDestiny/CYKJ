package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.WeatherPredictionDao;
import com.cykj.service.entity.WeatherPrediction;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/7/19 15:57.
 */
@Repository("weatherPredictionDao")
public class WeatherPredictionDaoImpl extends BaseDaoImpl<WeatherPrediction> implements WeatherPredictionDao {

    @Override
    public WeatherPrediction findWeatherPredictionByCity(String city) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CSS);
        String hql = "from WeatherPrediction where city =:city";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("city",city);
        List<WeatherPrediction> predictions = query.list();
        if (predictions == null || predictions.size() == 0){
            return null;
        }
        return predictions.get(0);
    }
}
