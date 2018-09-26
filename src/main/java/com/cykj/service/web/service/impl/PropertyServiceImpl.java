package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.PropertyDao;
import com.cykj.service.entity.Property;
import com.cykj.service.web.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/9/21 16:01.
 */
@Service("propertyService")
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService {

    @Autowired
    private PropertyDao propertyDao;

    @Override
    public Long saveAndGetId(Property property) {
        return propertyDao.saveAndGetId(property);
    }

    @Override
    public List<Property> getListByUniqueId(String uniqueId) {
        return propertyDao.getListByUniqueId(uniqueId);
    }
}
