package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Disaster;

import java.util.List;
import java.util.Map;


public interface DisasterEntityService extends BaseService<Disaster> {

    List<Disaster> findDisaster(Map<String,String> sqlMap);

}
