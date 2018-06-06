package com.cykj.service.base.model;

import com.cykj.service.base.annotoin.Lock;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yangsq
 * @date 2018/6/6 16:40.
 */
@MappedSuperclass
public class BaseEntity implements OptLock,NumericID<Long>,Serializable {

    static final long serialVersionUID = -1L;

    static final String NULL_SAFE_TEXT = "NA";

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = serialVersionUID;

    @Version
    @Column
    private Integer version = VERSION_NEW;

    @Lock
    @Column(columnDefinition = "int default 0")
    private int deleteStatus;// 是否删除,默认为0未删除，-1表示删除状态

    /**
     *
     */
    public BaseEntity() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Integer getVersion() {
        return this.version;
    }

    @Transient
    public boolean isTransient() {
        return (this.version == VERSION_NEW);
    }

    protected void setId(long id) {
        this.id = id;
    }

    protected void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return String.format("GenericEntity [id=%s]", id);
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


}
