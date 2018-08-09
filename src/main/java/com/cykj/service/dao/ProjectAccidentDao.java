package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.ProjectAccident;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/8/3 14:27.
 */
public interface ProjectAccidentDao  extends BaseDao<ProjectAccident> {

    List<ProjectAccident> findProjectAccidentByProjectId(long projectId);

}
