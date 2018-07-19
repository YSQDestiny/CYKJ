package com.cykj.service.base.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author yangsq
 * @date 2018/7/19 11:45.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSourceType();
    }
}
