package com.cykj.service.entity;

import com.cykj.service.base.model.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author yangsq
 * @date 2018/6/29 9:20.
 */
@Entity
@Table(name = "company", schema = "cykj", catalog = "")
public class CompanyEntity extends BaseEntity {
    private String addr;
    private String industry;
    private String linkman;
    @Temporal(TemporalType.TIMESTAMP)
    private Date makeTime;
    private String manager;
    private String name;
    private String safe;
    private String uniqueId;
    private String viceManager;
    private Integer wokerNormal;
    private Integer wokerSpecial;
    private String businessPhoto;
    private String industryPhoto;
    private String systemPhoto;
    private Integer amount;
    private Integer assets;
    private String coverage;
    private String insurance;
    private String city;
    private String county;
    private String province;
    private String companyCode;
    private String other;
    private String phoneNumber;
    private String town;
    private String client;
    private String clientContact;
    private String clientContactPhone;
    private String weatherStr;
    private String geologyStr;

    @Basic
    @Column(name = "addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "industry")
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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
    @Column(name = "makeTime")
    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "uniqueId")
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Basic
    @Column(name = "viceManager")
    public String getViceManager() {
        return viceManager;
    }

    public void setViceManager(String viceManager) {
        this.viceManager = viceManager;
    }

    @Basic
    @Column(name = "wokerNormal")
    public Integer getWokerNormal() {
        return wokerNormal;
    }

    public void setWokerNormal(Integer wokerNormal) {
        this.wokerNormal = wokerNormal;
    }

    @Basic
    @Column(name = "wokerSpecial")
    public Integer getWokerSpecial() {
        return wokerSpecial;
    }

    public void setWokerSpecial(Integer wokerSpecial) {
        this.wokerSpecial = wokerSpecial;
    }

    @Basic
    @Column(name = "businessPhoto")
    public String getBusinessPhoto() {
        return businessPhoto;
    }

    public void setBusinessPhoto(String businessPhoto) {
        this.businessPhoto = businessPhoto;
    }

    @Basic
    @Column(name = "industryPhoto")
    public String getIndustryPhoto() {
        return industryPhoto;
    }

    public void setIndustryPhoto(String industryPhoto) {
        this.industryPhoto = industryPhoto;
    }

    @Basic
    @Column(name = "systemPhoto")
    public String getSystemPhoto() {
        return systemPhoto;
    }

    public void setSystemPhoto(String systemPhoto) {
        this.systemPhoto = systemPhoto;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "assets")
    public Integer getAssets() {
        return assets;
    }

    public void setAssets(Integer assets) {
        this.assets = assets;
    }

    @Basic
    @Column(name = "coverage")
    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    @Basic
    @Column(name = "insurance")
    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "county")
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "companyCode")
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Basic
    @Column(name = "other")
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Basic
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "town")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Basic
    @Column(name = "client")
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Basic
    @Column(name = "client_contact")
    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    @Basic
    @Column(name = "client_contact_phone")
    public String getClientContactPhone() {
        return clientContactPhone;
    }

    public void setClientContactPhone(String clientContactPhone) {
        this.clientContactPhone = clientContactPhone;
    }

    public String getWeatherStr() {
        return weatherStr;
    }

    public void setWeatherStr(String weatherStr) {
        this.weatherStr = weatherStr;
    }

    public String getGeologyStr() {
        return geologyStr;
    }

    public void setGeologyStr(String geologyStr) {
        this.geologyStr = geologyStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}

        CompanyEntity that = (CompanyEntity) o;

        if (addr != null ? !addr.equals(that.addr) : that.addr != null){ return false;}
        if (industry != null ? !industry.equals(that.industry) : that.industry != null){ return false;}
        if (linkman != null ? !linkman.equals(that.linkman) : that.linkman != null){ return false;}
        if (makeTime != null ? !makeTime.equals(that.makeTime) : that.makeTime != null){ return false;}
        if (manager != null ? !manager.equals(that.manager) : that.manager != null){ return false;}
        if (name != null ? !name.equals(that.name) : that.name != null){ return false;}
        if (safe != null ? !safe.equals(that.safe) : that.safe != null){ return false;}
        if (uniqueId != null ? !uniqueId.equals(that.uniqueId) : that.uniqueId != null){ return false;}
        if (viceManager != null ? !viceManager.equals(that.viceManager) : that.viceManager != null){ return false;}
        if (wokerNormal != null ? !wokerNormal.equals(that.wokerNormal) : that.wokerNormal != null){ return false;}
        if (wokerSpecial != null ? !wokerSpecial.equals(that.wokerSpecial) : that.wokerSpecial != null){ return false;}
        if (businessPhoto != null ? !businessPhoto.equals(that.businessPhoto) : that.businessPhoto != null)
        { return false;}
        if (industryPhoto != null ? !industryPhoto.equals(that.industryPhoto) : that.industryPhoto != null)
        { return false;}
        if (systemPhoto != null ? !systemPhoto.equals(that.systemPhoto) : that.systemPhoto != null){ return false;}
        if (amount != null ? !amount.equals(that.amount) : that.amount != null){ return false;}
        if (assets != null ? !assets.equals(that.assets) : that.assets != null) { return false;}
        if (coverage != null ? !coverage.equals(that.coverage) : that.coverage != null){ return false;}
        if (insurance != null ? !insurance.equals(that.insurance) : that.insurance != null) { return false;}
        if (city != null ? !city.equals(that.city) : that.city != null) { return false;}
        if (county != null ? !county.equals(that.county) : that.county != null) { return false;}
        if (province != null ? !province.equals(that.province) : that.province != null) { return false;}
        if (companyCode != null ? !companyCode.equals(that.companyCode) : that.companyCode != null) { return false;}
        if (other != null ? !other.equals(that.other) : that.other != null) { return false;}
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) { return false;}
        if (town != null ? !town.equals(that.town) : that.town != null) { return false;}
        if (client != null ? !client.equals(that.client) : that.client != null) { return false;}
        if (clientContact != null ? !clientContact.equals(that.clientContact) : that.clientContact != null)
        { return false;}
        if (clientContactPhone != null ? !clientContactPhone.equals(that.clientContactPhone) : that.clientContactPhone != null)
        { return false;}

        return true;
    }

    @Override
    public int hashCode() {
        int result = addr != null ? addr.hashCode() : 0;
        result = 31 * result + (industry != null ? industry.hashCode() : 0);
        result = 31 * result + (linkman != null ? linkman.hashCode() : 0);
        result = 31 * result + (makeTime != null ? makeTime.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (safe != null ? safe.hashCode() : 0);
        result = 31 * result + (uniqueId != null ? uniqueId.hashCode() : 0);
        result = 31 * result + (viceManager != null ? viceManager.hashCode() : 0);
        result = 31 * result + (wokerNormal != null ? wokerNormal.hashCode() : 0);
        result = 31 * result + (wokerSpecial != null ? wokerSpecial.hashCode() : 0);
        result = 31 * result + (businessPhoto != null ? businessPhoto.hashCode() : 0);
        result = 31 * result + (industryPhoto != null ? industryPhoto.hashCode() : 0);
        result = 31 * result + (systemPhoto != null ? systemPhoto.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (assets != null ? assets.hashCode() : 0);
        result = 31 * result + (coverage != null ? coverage.hashCode() : 0);
        result = 31 * result + (insurance != null ? insurance.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (companyCode != null ? companyCode.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (clientContact != null ? clientContact.hashCode() : 0);
        result = 31 * result + (clientContactPhone != null ? clientContactPhone.hashCode() : 0);
        return result;
    }
}
