package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.ProjectAccidentDao;
import com.cykj.service.entity.ProjectAccident;
import com.cykj.service.web.service.ProjectAccidetnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/8/3 14:36.
 */
@Service("projectAccidentService")
public class ProjectAccidetnServiceImpl extends BaseServiceImpl<ProjectAccident> implements ProjectAccidetnService {

    @Autowired
    private ProjectAccidentDao ProjectAccidentDao;

    @Override
    public List<ProjectAccident> findProjectAccidentByProjectId(long projectId) {
        return ProjectAccidentDao.findProjectAccidentByProjectId(projectId);
    }
}
