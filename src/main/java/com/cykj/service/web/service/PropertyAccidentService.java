package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.PropertyAccident;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/9/26 15:11.
 */
public interface PropertyAccidentService extends BaseService<PropertyAccident> {

    List<PropertyAccident> findAccidentByPropertyId(Long propertyId);

}
