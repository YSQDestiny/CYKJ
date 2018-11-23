package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.HydroImage;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/11/22 16:29.
 */
public interface HydroImageService extends BaseService<HydroImage> {

    void saveImageList(List<HydroImage> imageList);

    List<HydroImage> findImagByHydroID(long hydroID);

}
