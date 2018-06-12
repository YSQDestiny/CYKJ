package com.cykj.service.dao;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.entity.Record;
import com.cykj.service.model.RecordModel;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/12 15:02.
 */
public interface RecordDao extends BaseDao<Record> {

    void saveModelList(List<Record> records, Long companyId);


    List<Record> findRecordByCompanyId(Long companyId);
}
