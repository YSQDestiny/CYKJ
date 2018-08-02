package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Disasters;

import java.util.List;
import java.util.Map;

public interface DisasterService extends BaseService<Disasters> {

    List<Disasters> findDisastersByAddress(String address);

    Map<String,List<Disasters>> findDisastersByAddressList(List<String> addressList);
}
