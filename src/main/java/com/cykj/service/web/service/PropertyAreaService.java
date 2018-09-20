package com.cykj.service.web.service;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.PropertyArea;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 9:29.
 */
public interface PropertyAreaService extends BaseService<PropertyArea> {

    Map<String,Object> findAllbyPage(Page page);

    List<PropertyArea> findAll();

}
