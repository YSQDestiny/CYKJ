package com.cykj.service.web.service.impl;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.AreaDao;
import com.cykj.service.entity.Area;
import com.cykj.service.web.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/6 11:10.
 */
@Service("areaService")
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService {

    @Autowired
    AreaDao areaDao;

    @Override
    public List<Area> findAll() {
        return areaDao.findAll();
    }

    @Override
    public List<Area> findAreaByIndustry(String industry) {
        return areaDao.findAreaByIndustry(industry);
    }

    @Override
    public Map<String, Object> findAllbyPage(Page page) {
        return areaDao.findAllbyPage(page);
    }

    @Override
    public Area findAreaByName(String name) {
        return areaDao.findAreaByName(name);
    }
}
