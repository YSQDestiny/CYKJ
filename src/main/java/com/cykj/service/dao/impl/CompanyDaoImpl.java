package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.CompanyDao;
import com.cykj.service.entity.CompanyEntity;
import com.cykj.service.model.CompanyModel;
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
    public Long saveAndGetId(CompanyModel companyModel) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        CompanyEntity companyEntity = companyModel.getCompanyEntity();
        getCurrentSession().save(companyEntity);
        return companyEntity.getId();
    }

    @Override
    public List<CompanyEntity> getListByUniqueId(String uniqueId) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from CompanyEntity where uniqueId = :uniqueId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("uniqueId",uniqueId);
        List<CompanyEntity> companyEntities = query.list();
        if (companyEntities == null | companyEntities.size() == 0){
            return null;
        }
        return companyEntities;
    }


}
