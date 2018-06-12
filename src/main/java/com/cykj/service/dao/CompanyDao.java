package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.CompanyEntity;
import com.cykj.service.model.CompanyModel;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/6 17:17.
 */
public interface CompanyDao extends BaseDao<CompanyEntity>{

    /**
     * 插入数据并返回ID
     * @param CompanyModel
     * @return
     */
    Long saveAndGetId(CompanyModel companyModel);

    /**
     * 获取列表
     * @param uniqueId
     * @return
     */
    List<CompanyEntity> getListByUniqueId(String uniqueId);

}
