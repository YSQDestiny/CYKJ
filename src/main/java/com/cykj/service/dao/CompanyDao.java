package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.CompanyEntity;

import java.util.List;

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

    /**
     * 获取列表
     * @param uniqueId
     * @return
     */
    List<CompanyEntity> getListByUniqueId(String uniqueId);

}
