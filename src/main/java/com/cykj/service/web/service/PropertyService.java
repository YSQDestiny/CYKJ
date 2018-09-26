package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.entity.Property;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/9/21 16:00.
 */
public interface PropertyService extends BaseService<Property> {

    /**
     * 插入数据并返回ID
     * @param Property
     * @return
     */
    Long saveAndGetId(Property property);

    /**
     * 获取列表
     * @param uniqueId
     * @return
     */
    List<Property> getListByUniqueId(String uniqueId);

}
