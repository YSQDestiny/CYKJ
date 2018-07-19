package com.cykj.service.web.service.impl;

import com.cykj.service.base.bean.Page;
import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.IndustryDao;
import com.cykj.service.entity.Industry;
import com.cykj.service.web.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yangsq
 * @date 2018/7/18 9:56.
 */
@Service("industryService")
public class IndustryServiceImpl extends BaseServiceImpl<Industry> implements IndustryService {

    @Autowired
    private IndustryDao industryDao;

    @Override
    public Map<String, Object> findAllByPage(Page page) {
        return industryDao.findAllByPage(page);
    }

    @Override
    public Industry findIndustryByName(String name) {
        return industryDao.findIndustryByName(name);
    }
}
