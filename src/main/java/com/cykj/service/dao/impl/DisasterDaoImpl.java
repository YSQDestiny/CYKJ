package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.DisasterDao;
import com.cykj.service.entity.Disaster;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("disasterDao")
public class DisasterDaoImpl extends BaseDaoImpl<Disaster> implements DisasterDao {


    @Override
    public List<Disaster> findDisaster(Map<String, String> sqlMap) {
        int i = 0;
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Disaster";
        for (String str : sqlMap.keySet()){
            if (i == 0){
                hql += " where " + str + " =:" + str;
                i++;
            }else if (i > 0){
                hql += " and " + str + " =:" + str;
            }
        }
        Query query = getCurrentSession().createQuery(hql);
        for (String str : sqlMap.keySet()){
            query.setParameter(str,sqlMap.get(str));
        }
        List<Disaster> disasterList = query.list();
        if (disasterList == null || disasterList.size() == 0){
            return null;
        }
        return disasterList;
    }


}
