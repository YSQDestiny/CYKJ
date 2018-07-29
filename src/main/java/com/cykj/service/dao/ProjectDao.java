package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Project;

import java.util.List;

public interface ProjectDao extends BaseDao<Project>{

    List<Project> findAllByUniqueId(String uniqueId);

    public Long saveAndGetId(Project project);
}
