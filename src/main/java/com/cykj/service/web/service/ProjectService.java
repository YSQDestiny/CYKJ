package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Project;

import java.util.List;

public interface ProjectService extends BaseService<Project> {

    List<Project> findAllByUniqueId(String uniqueId);

    public Long saveAndGetId(Project project);
}
