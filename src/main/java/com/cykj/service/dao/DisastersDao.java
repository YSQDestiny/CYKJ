package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Disasters;

import java.util.List;
import java.util.Map;

public interface DisastersDao extends BaseDao<Disasters> {

    List<Disasters> findDisastersByAddress(String address);

    Map<String,List<Disasters>> findDisastersByAddressList(List<String> addressList);
}
