package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.DisastersDao;
import com.cykj.service.entity.Disasters;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("disastersDao")
public class DisastersDaoImpl extends BaseDaoImpl<Disasters> implements DisastersDao{


    @Override
    public List<Disasters> findDisastersByAddress(String address) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.ZHDN);
        String hql = "from Disasters where address = :address";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("address",address);
        List<Disasters> disasters = query.list();
        if (disasters != null || disasters.size() == 0){
            return null;
        }
        return disasters;
    }
}
