package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.AccidentEntity;
import com.cykj.service.entity.PropertyAccident;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/9/26 15:06.
 */
public interface PropertyAccidentDao extends BaseDao<PropertyAccident> {

    List<PropertyAccident> findAccidentByPropertyId(Long propertyId);

}
