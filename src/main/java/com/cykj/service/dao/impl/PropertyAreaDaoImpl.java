package com.cykj.service.dao.impl;

import com.cykj.service.base.Constants;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.PropertyAreaDao;
import com.cykj.service.entity.PropertyArea;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 9:24.
 */
@Repository("propertyAreaDao")
public class PropertyAreaDaoImpl extends BaseDaoImpl<PropertyArea> implements PropertyAreaDao {

    @Override
    public Map<String, Object> findAllbyPage(Page page) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        Map<String,Object> returnMap = new HashMap<>();
        String hql = "from PropertyArea";
        Query query = getCurrentSession().createQuery(hql);
        returnMap.put(Constants.TOTALS,query.list().size());
        query.setProperties(null);
        query.setFirstResult((page.getPage() -1) * page.getRows());
        query.setMaxResults(page.getRows());
        returnMap.put(Constants.ROWS,query.list());
        return returnMap;
    }

    @Override
    public List<PropertyArea> findAll() {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from PropertyArea";
        Query query = getCurrentSession().createQuery(hql);
        List<PropertyArea> propertyAreaList = query.list();
        if (propertyAreaList == null || propertyAreaList.size() == 0){
            return null;
        }
        return propertyAreaList;
    }
}
