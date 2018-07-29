package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Disasters;

import java.util.List;

public interface DisasterService extends BaseService<Disasters> {

    List<Disasters> findDisastersByAddress(String address);

}
