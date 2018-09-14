package com.cykj.service.web.service;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Area;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/6 11:09.
 */
public interface AreaService extends BaseService<Area> {

    List<Area> findAll();

    /**
     *
     * @return
     */
    List<Area> findAreaByIndustry(String industry);

    Map<String,Object> findAllbyPage(Page page);

    Area findAreaByName(String name);
}
