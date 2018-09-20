package com.cykj.service.dao.impl;

import com.cykj.service.base.Constants;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.PropertyOptionDao;
import com.cykj.service.entity.PropertyOption;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 10:56.
 */
@Repository("propertyOptionDao")
public class PropertyOptionDaoImpl extends BaseDaoImpl<PropertyOption> implements  PropertyOptionDao{
    @Override
    public Map<String, Object> findAllbyPage(Page page) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        Map<String,Object> returnMap = new HashMap<>();
        String hql = "from PropertyOption";
        Query query = getCurrentSession().createQuery(hql);
        returnMap.put(Constants.TOTALS,query.list().size());
        query.setProperties(null);
        query.setFirstResult((page.getPage() -1) * page.getRows());
        query.setMaxResults(page.getRows());
        returnMap.put(Constants.ROWS,query.list());
        return returnMap;
    }

    @Override
    public List<PropertyOption> findOptionByArea(String area) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from PropertyOption where area=:area";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("area",area);
        List<PropertyOption> optionList = query.list();
        if (optionList == null || optionList.size() == 0){
            return null;
        }
        return optionList;
    }
}
