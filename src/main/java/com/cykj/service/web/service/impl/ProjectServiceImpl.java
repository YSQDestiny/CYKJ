package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.ProjectDao;
import com.cykj.service.entity.Project;
import com.cykj.service.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService{

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> findAllByUniqueId(String uniqueId) {
        return projectDao.findAllByUniqueId(uniqueId);
    }

    @Override
    public Long saveAndGetId(Project project) {
        return projectDao.saveAndGetId(project);
    }
}
