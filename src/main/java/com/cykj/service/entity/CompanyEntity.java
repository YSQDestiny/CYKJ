package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yangsq
 * @date 2018/6/6 17:16.
 */
@Entity
@Table(name = "company", schema = "cykj", catalog = "")
public class CompanyEntity extends BaseEntity{
    private String name;
    private String addr;
    private String linkman;
    private String manager;
    private String viceManager;
    private String safe;
    private Integer wokerNormal;
    private Integer wokerSpecial;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "linkman")
    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    @Basic
    @Column(name = "manager")
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Basic
    @Column(name = "vice_manager")
    public String getViceManager() {
        return viceManager;
    }

    public void setViceManager(String viceManager) {
        this.viceManager = viceManager;
    }

    @Basic
    @Column(name = "safe")
    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }

    @Basic
    @Column(name = "woker_normal")
    public Integer getWokerNormal() {
        return wokerNormal;
    }

    public void setWokerNormal(Integer wokerNormal) {
        this.wokerNormal = wokerNormal;
    }

    @Basic
    @Column(name = "woker_special")
    public Integer getWokerSpecial() {
        return wokerSpecial;
    }

    public void setWokerSpecial(Integer wokerSpecial) {
        this.wokerSpecial = wokerSpecial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (addr != null ? !addr.equals(that.addr) : that.addr != null) return false;
        if (linkman != null ? !linkman.equals(that.linkman) : that.linkman != null) return false;
        if (manager != null ? !manager.equals(that.manager) : that.manager != null) return false;
        if (viceManager != null ? !viceManager.equals(that.viceManager) : that.viceManager != null) return false;
        if (safe != null ? !safe.equals(that.safe) : that.safe != null) return false;
        if (wokerNormal != null ? !wokerNormal.equals(that.wokerNormal) : that.wokerNormal != null) return false;
        if (wokerSpecial != null ? !wokerSpecial.equals(that.wokerSpecial) : that.wokerSpecial != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        result = 31 * result + (linkman != null ? linkman.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (viceManager != null ? viceManager.hashCode() : 0);
        result = 31 * result + (safe != null ? safe.hashCode() : 0);
        result = 31 * result + (wokerNormal != null ? wokerNormal.hashCode() : 0);
        result = 31 * result + (wokerSpecial != null ? wokerSpecial.hashCode() : 0);
        return result;
    }
}
