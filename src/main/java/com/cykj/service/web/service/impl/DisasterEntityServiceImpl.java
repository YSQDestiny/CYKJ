package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.DisasterDao;
import com.cykj.service.entity.Disaster;
import com.cykj.service.web.service.DisasterEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("disasterEntityService")
public class DisasterEntityServiceImpl extends BaseServiceImpl<Disaster> implements DisasterEntityService {

    @Autowired
    private DisasterDao disasterDao;

    @Override
    public List<Disaster> findDisaster(Map<String, String> sqlMap) {
        return disasterDao.findDisaster(sqlMap);
    }

}
