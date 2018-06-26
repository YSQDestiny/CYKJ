package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yangsq
 * @date 2018/6/7 9:44.
 */
@Entity
@Table(name = "company")
public class CompanyEntity extends BaseEntity {

    //企业名称
    private String name;
    //企业编码
    private String companyCode;
    //详细地址
    private String addr;
    //联系人
    private String linkman;
    //联系电话
    private String phoneNumber;
    //总经理
    private String manager;
    //副总经理
    private String viceManager;
    //安全负责人
    private String safe;
    //普通工人
    private Integer wokerNormal;
    //特殊工人
    private Integer wokerSpecial;
    //省
    private String province;
    //市
    private String city;
    //县
    private String county;
    //镇
    private String town;
    //固定资产
    private Integer assets;
    //年营业额
    private Integer amount;
    //投保范围
    private String coverage;
    //投保险种
    private String insurance;
    //时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date makeTime;
    //设备识别码
    private String uniqueId;
    //行业
    private String industry;
    private String businessPhoto;
    private String industryPhoto;
    private String systemPhoto;
    //其他
    private String other;
    //委托方
    private String client;

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

    @Basic
    @Column(name = "makeTime")
    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getBusinessPhoto() {
        return businessPhoto;
    }

    public void setBusinessPhoto(String businessPhoto) {
        this.businessPhoto = businessPhoto;
    }

    public String getIndustryPhoto() {
        return industryPhoto;
    }

    public void setIndustryPhoto(String industryPhoto) {
        this.industryPhoto = industryPhoto;
    }

    public String getSystemPhoto() {
        return systemPhoto;
    }

    public void setSystemPhoto(String systemPhoto) {
        this.systemPhoto = systemPhoto;
    }

    public Integer getAssets() {
        return assets;
    }

    public void setAssets(Integer assets) {
        this.assets = assets;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phontNumber) {
        this.phoneNumber = phontNumber;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
