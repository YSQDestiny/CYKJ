package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.dao.CompanyDao;
import com.cykj.service.entity.CompanyEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author yangsq
 * @date 2018/6/6 17:17.
 *
 */
@Repository("companyDao")
public class CompanyDaoImpl extends BaseDaoImpl<CompanyEntity> implements CompanyDao {

    @Override
    public Session getCurrentSession() {
        return super.getCurrentSession();
    }


    @Override
    public Long saveAndGetId(CompanyEntity companyEntity) {
        CompanyEntity company = (CompanyEntity) getCurrentSession().save(companyEntity);
        return company.getId();
    }
}
