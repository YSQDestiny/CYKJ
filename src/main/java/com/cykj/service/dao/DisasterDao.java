package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Disaster;

import java.util.List;
import java.util.Map;

public interface DisasterDao extends BaseDao<Disaster> {

    List<Disaster> findDisaster(Map<String,String> sqlMap);

}
