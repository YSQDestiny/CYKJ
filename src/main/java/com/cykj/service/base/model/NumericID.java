package com.cykj.service.base.model;

import java.io.Serializable;

/**
 * @author yangsq
 * @date 2018/6/6 16:39.
 */
public interface NumericID<ID extends Serializable> {

    ID getId();

}
