package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.CompanyEntity;
import com.cykj.service.model.CompanyModel;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/6 17:19.
 */
public interface CompanyService extends BaseService<CompanyEntity>{

    /**
     * 插入数据并返回ID
     * @param CompanyModel
     * @return
     */
    Long saveAndGetId(CompanyModel companyModel);

    List<CompanyEntity> getListByUniqueId(String uniqueId);
}
