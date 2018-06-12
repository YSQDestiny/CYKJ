package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.AccidentDao;
import com.cykj.service.entity.AccidentEntity;
import com.cykj.service.web.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/8 16:23.
 */
@Service("accidentService")
public class AccidentServiceImpl extends BaseServiceImpl<AccidentEntity> implements AccidentService{

    @Autowired
    AccidentDao accidentDao;

    @Override
    public List<AccidentEntity> findAccidentByCompanyId(Long companyId) {
        return accidentDao.findAccidentByCompanyId(companyId);
    }
}
