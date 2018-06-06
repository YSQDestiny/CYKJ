package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.CompanyEntity;

/**
 * @author yangsq
 * @date 2018/6/6 17:17.
 */
public interface CompanyDao extends BaseDao<CompanyEntity>{

    /**
     * 插入数据并返回ID
     * @param companyEntity
     * @return
     */
    Long saveAndGetId(CompanyEntity companyEntity);

}
