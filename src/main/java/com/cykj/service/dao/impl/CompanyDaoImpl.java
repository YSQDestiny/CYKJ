package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.dao.CompanyDao;
import com.cykj.service.entity.CompanyEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/6 17:17.
 *
 */
@Repository("companyDao")
public class CompanyDaoImpl extends BaseDaoImpl<CompanyEntity> implements CompanyDao {

    @Override
    public Long saveAndGetId(CompanyEntity companyEntity) {
        getCurrentSession().save(companyEntity);
        return companyEntity.getId();
    }

    @Override
    public List<CompanyEntity> getListByUniqueId(String uniqueId) {
        String hql = "select from company where uniqueId = :uniqueId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("uniqueId",uniqueId);
        List<CompanyEntity> companyEntities = query.list();
        if (companyEntities == null | companyEntities.size() == 0){
            return null;
        }
        return companyEntities;
    }


}
