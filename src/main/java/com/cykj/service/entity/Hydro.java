package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangsq
 * @date 2018/11/6 9:09.
 */
@Entity
@Table(name = "hydro", schema = "cykj", catalog = "")
public class Hydro extends BaseEntity {

    /**
     * 名称
     */
    private String name;
    /**
     * 地址
     */
    private String addr;
    /**
     *城市
     */
    private String city;
    /**
     *区/县
     */
    private String county;
    /**
     *省
     */
    private String province;

    
}
