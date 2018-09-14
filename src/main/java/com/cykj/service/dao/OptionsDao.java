package com.cykj.service.dao;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Options;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/7 10:17.
 */
public interface OptionsDao extends BaseDao<Options> {

    List<Options> findAll();

    Map<String,Object> findAllbyPage(Page page);

    List<Options> findOptionsByIndustryAndArea(String inudstry,String area);

}
