package com.cykj.service.web.service;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Industry;

import java.util.Map;

/**
 * @author yangsq
 * @date 2018/7/18 9:51.
 */
public interface IndustryService extends BaseService<Industry> {

    Map<String,Object> findAllByPage(Page page);

    Industry findIndustryByName(String name);

}
