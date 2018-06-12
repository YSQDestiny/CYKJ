package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.AccidentEntity;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/8 16:22.
 */
public interface AccidentService extends BaseService<AccidentEntity> {

    List<AccidentEntity> findAccidentByCompanyId(Long companyId);

}
