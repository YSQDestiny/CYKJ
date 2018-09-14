package com.cykj.service.web.service.impl;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.entity.Options;
import com.cykj.service.dao.OptionsDao;
import com.cykj.service.web.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/7 10:22.
 */
@Service("optionsService")
public class OptionsServiceImpl extends BaseServiceImpl<Options> implements OptionsService {

    @Autowired
    private OptionsDao optionsDao;


    @Override
    public List<Options> findAll() {
        return optionsDao.findAll();
    }

    @Override
    public Map<String, Object> findAllbyPage(Page page) {
        return optionsDao.findAllbyPage(page);
    }

    @Override
    public List<Options> findOptionsByIndustryAndArea(String inudstry, String area) {
        return optionsDao.findOptionsByIndustryAndArea(inudstry,area);
    }
}
