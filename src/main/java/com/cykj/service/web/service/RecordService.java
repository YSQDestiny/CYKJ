package com.cykj.service.web.service;

import com.cykj.service.base.service.BaseService;
import com.cykj.service.entity.Record;
import com.cykj.service.model.RecordModel;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/12 15:07.
 */
public interface RecordService extends BaseService<Record> {

    void saveModelList(List<Record> records, Long companyId);

    List<Record> findRecordByCompanyId(Long companyId);

}
