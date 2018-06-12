package com.cykj.service.model;

import com.cykj.service.entity.AccidentEntity;
import com.cykj.service.entity.CompanyEntity;
import com.cykj.service.entity.Record;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/6/12 14:30.
 */
public class CompanyModel  {

    private CompanyEntity companyEntity;

    private List<Record> records;

    private List<AccidentEntity> accidents;

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<AccidentEntity> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<AccidentEntity> accidents) {
        this.accidents = accidents;
    }
}
