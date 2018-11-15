package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.HydroDao;
import com.cykj.service.entity.Hydro;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/11/9 10:49.
 */
@Repository("hydroDao")
public class HydroDaoImpl extends BaseDaoImpl<Hydro> implements HydroDao {
    @Override
    public Long saveAndGetId(Hydro hydro) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        getCurrentSession().save(hydro);
        return hydro.getId();
    }

    @Override
    public List<Hydro> getListByUniqueId(String uniqueId) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Hydro where uniqueId = :uniqueId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("uniqueId",uniqueId);
        List<Hydro> hydros = query.list();
        if (hydros == null || hydros.size() == 0){
            return null;
        }
        return hydros;
    }
}
