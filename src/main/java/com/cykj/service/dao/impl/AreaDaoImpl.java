package com.cykj.service.dao.impl;

import com.cykj.service.base.Constants;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.AreaDao;
import com.cykj.service.entity.Area;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/6 11:08.
 */
@Repository("areaDao")
public class AreaDaoImpl extends BaseDaoImpl<Area> implements AreaDao {


    @Override
    public List<Area> findAll() {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Area";
        Query query = getCurrentSession().createQuery(hql);
        List<Area> areaList = query.list();
        if (areaList == null || areaList.size() == 0){
            return null;
        }
        return areaList;
    }

    @Override
    public List<Area> findAreaByIndustry(String industry) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Area where industry = :industry";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("industry",industry);
        List<Area> areas = query.list();
        if (areas == null || areas.size() == 0){
            return null;
        }
        return areas;
    }

    @Override
    public Map<String, Object> findAllbyPage(Page page) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        Map<String,Object> returnMap = new HashMap<>();
        String hql = "from Area";
        Query query = getCurrentSession().createQuery(hql);
        returnMap.put(Constants.TOTALS,query.list().size());
        query.setProperties(null);
        query.setFirstResult((page.getPage() -1) * page.getRows());
        query.setMaxResults(page.getRows());
        returnMap.put(Constants.ROWS,query.list());
        return returnMap;
    }

    @Override
    public Area findAreaByName(String name) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Area where name = :name";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("name",name);
        List<Area> areas = query.list();
        if (areas == null || areas.size() == 0){
            return null;
        }
        return areas.get(0);
    }
}
