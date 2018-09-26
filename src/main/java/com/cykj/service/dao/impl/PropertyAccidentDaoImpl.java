package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.PropertyAccidentDao;
import com.cykj.service.entity.PropertyAccident;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/9/26 15:08.
 */
@Repository("propertyAccidentDao")
public class PropertyAccidentDaoImpl extends BaseDaoImpl<PropertyAccident> implements PropertyAccidentDao {
    @Override
    public List<PropertyAccident> findAccidentByPropertyId(Long propertyId) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from PropertyAccident where propertyId = :propertyId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("propertyId",propertyId);
        List<PropertyAccident> propertyAccidents = query.list();
        if (propertyAccidents == null || propertyAccidents.size() == 0){
            return null;
        }
        return propertyAccidents;
    }
}
