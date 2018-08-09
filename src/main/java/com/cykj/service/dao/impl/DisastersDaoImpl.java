package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.DisastersDao;
import com.cykj.service.entity.Disasters;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String,List<Disasters>> findDisastersByAddressList(List<String> addressList) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.ZHDN);
        Map<String ,List<Disasters>> map = new HashMap<>();
        for (String address : addressList){
            String hql = "from Disasters where address =:address";
            Query query = getCurrentSession().createQuery(hql);
            query.setString("address",address);
            List<Disasters> disastersList = query.list();
            if (disastersList == null || disastersList.size() == 0){
                map.put(address,null);
            }else {
                map.put(address,disastersList);
            }
        }
        return map;
    }
}
