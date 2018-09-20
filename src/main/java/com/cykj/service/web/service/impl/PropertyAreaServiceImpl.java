package com.cykj.service.web.service.impl;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.PropertyAreaDao;
import com.cykj.service.entity.PropertyArea;
import com.cykj.service.web.service.PropertyAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 9:30.
 */
@Service("propertyAreaService")
public class PropertyAreaServiceImpl extends BaseServiceImpl<PropertyArea> implements PropertyAreaService {

    @Autowired
    private PropertyAreaDao propertyAreaDao;

    @Override
    public Map<String, Object> findAllbyPage(Page page) {
        return propertyAreaDao.findAllbyPage(page);
    }

    @Override
    public List<PropertyArea> findAll() {
        return propertyAreaDao.findAll();
    }
}
