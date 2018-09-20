package com.cykj.service.dao;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.PropertyOption;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 10:36.
 */
public interface PropertyOptionDao extends BaseDao<PropertyOption> {

    Map<String,Object> findAllbyPage(Page page);

    List<PropertyOption> findOptionByArea(String area);

}
