package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.AccidentEntity;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/8 16:24.
 */
public interface AccidentDao extends BaseDao<AccidentEntity>{

    List<AccidentEntity> findAccidentByCompanyId(Long companyId);

}
