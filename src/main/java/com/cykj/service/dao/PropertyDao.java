package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Property;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/9/21 15:51.
 */
public interface PropertyDao extends BaseDao<Property> {

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
