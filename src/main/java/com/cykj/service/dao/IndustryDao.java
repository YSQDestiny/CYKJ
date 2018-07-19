package com.cykj.service.dao;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Industry;

import java.util.Map;

/**
 * @author yangsq
 * @date 2018/7/18 9:29.
 */
public interface IndustryDao extends BaseDao<Industry> {

    Map<String,Object> findAllByPage(Page page);

    Industry findIndustryByName(String name);
}
