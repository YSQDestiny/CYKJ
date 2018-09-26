package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.PropertyAccidentDao;
import com.cykj.service.entity.PropertyAccident;
import com.cykj.service.web.service.PropertyAccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/9/26 15:12.
 */
@Service("propertyAccidentService")
public class PropertyAccidentServiceImpl extends BaseServiceImpl<PropertyAccident> implements PropertyAccidentService {

    @Autowired
    private PropertyAccidentDao propertyAccidentDao;

    @Override
    public List<PropertyAccident> findAccidentByPropertyId(Long propertyId) {
        return propertyAccidentDao.findAccidentByPropertyId(propertyId);
    }
}
