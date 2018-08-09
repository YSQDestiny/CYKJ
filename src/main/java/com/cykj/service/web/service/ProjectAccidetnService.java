package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.ProjectAccident;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/8/3 14:35.
 */
public interface ProjectAccidetnService extends BaseService<ProjectAccident> {

    List<ProjectAccident> findProjectAccidentByProjectId(long projectId);

}
