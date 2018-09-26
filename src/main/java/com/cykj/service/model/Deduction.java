package com.cykj.service.model;

/**
 * @author yangsq
 * @date 2018/9/26 14:34.
 */
public class Deduction {

    /**
     * 扣分
     */
    private int deduction;

    /**
     * 区域
     */
    private String area;

    /**
     * 扣分原因
     */
    private String reson;

    /**
     * 是否缺项
     */
    private boolean isMissing;

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public boolean isMissing() {
        return isMissing;
    }

    public void setMissing(boolean missing) {
        isMissing = missing;
    }
}
