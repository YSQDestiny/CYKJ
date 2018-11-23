package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.HydroImage;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/11/22 15:03.
 */
public interface HydroImageDao extends BaseDao<HydroImage> {

    void saveImageList(List<HydroImage> imageList);

    List<HydroImage> findImagByHydroID(long hydroID);

}
