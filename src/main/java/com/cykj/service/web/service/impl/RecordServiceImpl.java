package com.cykj.service.web.service.impl;

import com.cykj.service.base.service.impl.BaseServiceImpl;
import com.cykj.service.dao.RecordDao;
import com.cykj.service.entity.Record;
import com.cykj.service.model.RecordModel;
import com.cykj.service.web.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/12 15:08.
 */
@Service("recordService")
public class RecordServiceImpl extends BaseServiceImpl<Record> implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Override
    public void saveModelList(List<Record> records, Long companyId) {
        recordDao.saveModelList(records,companyId);
    }

    @Override
    public List<Record> findRecordByCompanyId(Long companyId) {
        return recordDao.findRecordByCompanyId(companyId);
    }
}
