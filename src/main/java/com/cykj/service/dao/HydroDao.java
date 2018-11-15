package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Hydro;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/11/9 10:35.
 */
public interface HydroDao extends BaseDao<Hydro> {

    /**
     * 储存并返回ID
     * @param hydro
     * @return
     */
    Long saveAndGetId(Hydro hydro);

    /**
     * 根据设备编码获取列表
     * @param uniqueId
     * @return
     */
    List<Hydro> getListByUniqueId(String uniqueId);
}
