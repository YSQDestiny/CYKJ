package com.cykj.service.web.service;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Options;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/7 10:21.
 */
public interface OptionsService extends BaseService<Options> {

    List<Options> findAll();

    Map<String,Object> findAllbyPage(Page page);

    List<Options> findOptionsByIndustryAndArea(String inudstry,String area);

}
