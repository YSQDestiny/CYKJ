package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.dao.AccidentDao;
import com.cykj.service.entity.AccidentEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/8 16:24.
 */
@Repository("accidentDao")
public class AccidentDaoImpl extends BaseDaoImpl<AccidentEntity> implements AccidentDao {
    @Override
    public List<AccidentEntity> findAccidentByCompanyId(Long companyId) {
        String hql = "from AccidentEntity where companyId = :companyId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("companyId",companyId);
        List<AccidentEntity> accidentList = query.list();
        if (accidentList == null && accidentList.size() == 0){
            return null;
        }
        return accidentList;
    }
}
