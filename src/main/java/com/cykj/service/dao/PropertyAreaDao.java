package com.cykj.service.dao;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.PropertyArea;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 9:22.
 */
public interface PropertyAreaDao extends BaseDao<PropertyArea> {

    Map<String,Object> findAllbyPage(Page page);

    List<PropertyArea> findAll();

}
