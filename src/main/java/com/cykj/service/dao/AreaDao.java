package com.cykj.service.dao;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Area;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/6 11:04.
 */
public interface AreaDao extends BaseDao<Area> {

    List<Area> findAll();

    List<Area> findAreaByIndustry(String industry);

    Map<String,Object> findAllbyPage(Page page);

    Area findAreaByName(String name);
}
