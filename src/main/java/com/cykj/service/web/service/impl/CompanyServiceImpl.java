package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.CompanyDao;
import com.cykj.service.entity.CompanyEntity;
import com.cykj.service.web.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/6 17:19.
 */
@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<CompanyEntity> implements CompanyService{

    @Autowired
    private CompanyDao companyDao;

    @Override
    public Long saveAndGetId(CompanyEntity companyEntity) {
        return companyDao.saveAndGetId(companyEntity);
    }

    @Override
    public List<CompanyEntity> getListByUniqueId(String uniqenId) {
        return companyDao.getListByUniqenId(uniqenId);
    }
}
