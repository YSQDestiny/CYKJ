package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.dao.RecordDao;
import com.cykj.service.entity.Record;
import com.cykj.service.model.RecordModel;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/12 15:03.
 */
@Repository("recoedDao")
public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao {

    @Override
    public void saveModelList(List<Record> records, Long companyId) {
        for (Record recordModel : records){
            getCurrentSession().save(recordModel);
        }
    }

    @Override
    public List<Record> findRecordByCompanyId(Long companyId) {
        String hql = "from Record where companyId = :companyId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("companyId",companyId);
        List<Record> records = query.list();
        if (records == null || records.size() == 0){
            return null;
        }
        return records;
    }


}
