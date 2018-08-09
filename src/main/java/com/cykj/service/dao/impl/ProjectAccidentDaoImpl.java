package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.ProjectAccidentDao;
import com.cykj.service.dao.ProjectDao;
import com.cykj.service.entity.ProjectAccident;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/8/3 14:31.
 */
@Repository("projectAccidentDao")
public class ProjectAccidentDaoImpl extends BaseDaoImpl<ProjectAccident> implements ProjectAccidentDao {


    @Override
    public List<ProjectAccident> findProjectAccidentByProjectId(long projectId) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from ProjectAccident where projectId = :projectId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("projectId",projectId);
        List<ProjectAccident> projectAccidents = query.list();
        if (projectAccidents == null || projectAccidents.size() == 0){
            return null;
        }
        return projectAccidents;
    }
}
