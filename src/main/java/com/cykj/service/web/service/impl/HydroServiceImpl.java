package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.HydroDao;
import com.cykj.service.entity.Hydro;
import com.cykj.service.web.service.HydroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/11/9 11:11.
 */
@Service("hydroService")
public class HydroServiceImpl extends BaseServiceImpl<Hydro> implements HydroService {

    @Autowired
    private HydroDao hydroDao;

    @Override
    public Long saveAndGetId(Hydro hydro) {
        return hydroDao.saveAndGetId(hydro);
    }

    @Override
    public List<Hydro> getListByUniqueId(String uniqueId) {
        return hydroDao.getListByUniqueId(uniqueId);
    }
}
