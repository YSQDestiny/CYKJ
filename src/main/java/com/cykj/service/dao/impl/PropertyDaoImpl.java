package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.PropertyDao;
import com.cykj.service.entity.Property;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/9/21 15:52.
 */
@Repository("peopertyDao")
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao {

    @Override
    public Long saveAndGetId(Property property) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        getCurrentSession().save(property);
        return property.getId();
    }

    @Override
    public List<Property> getListByUniqueId(String uniqueId) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Property where uniqueId = :uniqueId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("uniqueId",uniqueId);
        List<Property> propertyList = query.list();
        if (propertyList == null || propertyList.size() == 0){
            return null;
        }
        return propertyList;
    }
}
