package com.cykj.service.web.service.impl;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.PropertyOptionDao;
import com.cykj.service.entity.PropertyOption;
import com.cykj.service.web.service.PropertyOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 11:49.
 */
@Service("propertyOptionService")
public class PropertyOptionServiceImpl extends BaseServiceImpl<PropertyOption> implements PropertyOptionService {

    @Autowired
    private PropertyOptionDao propertyOptionDao;


    @Override
    public Map<String, Object> findAllbyPage(Page page) {
        return propertyOptionDao.findAllbyPage(page);
    }

    @Override
    public List<PropertyOption> findOptionByArea(String area) {
        return propertyOptionDao.findOptionByArea(area);
    }
}
