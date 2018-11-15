package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Hydro;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/11/9 11:10.
 */
public interface HydroService extends BaseService<Hydro> {

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
