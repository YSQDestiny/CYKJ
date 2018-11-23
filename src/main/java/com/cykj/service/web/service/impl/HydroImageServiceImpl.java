package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.HydroImageDao;
import com.cykj.service.entity.HydroImage;
import com.cykj.service.web.service.HydroImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/11/22 16:33.
 */
@Service("hydroImageService")
public class HydroImageServiceImpl extends BaseServiceImpl<HydroImage> implements HydroImageService {

    @Autowired
    private HydroImageDao hydroImageDao;

    @Override
    public void saveImageList(List<HydroImage> imageList) {
        hydroImageDao.saveImageList(imageList);
    }

    @Override
    public List<HydroImage> findImagByHydroID(long hydroID) {
        return hydroImageDao.findImagByHydroID(hydroID);
    }
}
