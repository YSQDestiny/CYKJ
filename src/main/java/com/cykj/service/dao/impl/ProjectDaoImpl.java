package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.ProjectDao;
import com.cykj.service.entity.Project;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("projectDao")
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {

    @Override
    public List<Project> findAllByUniqueId(String uniqueId) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Project where uniqueId = :uniqueId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("uniqueId",uniqueId);
        List<Project> projects = query.list();
        if (projects == null || projects.size() == 0){
            return null;
        }
        return projects;
    }

    @Override
    public Long saveAndGetId(Project project) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        getCurrentSession().save(project);
        return project.getId();
    }
}
