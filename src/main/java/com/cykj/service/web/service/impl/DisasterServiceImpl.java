package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.DisastersDao;
import com.cykj.service.entity.Disasters;
import com.cykj.service.web.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("disasterService")
public class DisasterServiceImpl extends BaseServiceImpl<Disasters> implements DisasterService {

    @Autowired
    private DisastersDao disastersDao;

    @Override
    public List<Disasters> findDisastersByAddress(String address) {
        return disastersDao.findDisastersByAddress(address);
    }

    @Override
    public Map<String, List<Disasters>> findDisastersByAddressList(List<String> addressList) {
        return disastersDao.findDisastersByAddressList(addressList);
    }
}
