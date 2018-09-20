package com.cykj.service.web.service;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.PropertyOption;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 11:46.
 */
public interface PropertyOptionService extends BaseService<PropertyOption> {

    Map<String,Object> findAllbyPage(Page page);

    List<PropertyOption> findOptionByArea(String area);

}
