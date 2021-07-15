package com.zhong.po;

import java.util.Date;

/**
 * @author 华韵流风
 * @ClassName SellDetail
 * @Description TODO
 * @Date 2021/7/15 9:44
 * @packageName com.zhong.po
 */
public class SellDetail {

    private int id;
    private String sellName;
    private double sellPrice;
    private int sellCount;
    private Date sellTime;
    private int medid;
    private int userid;

    @Override
    public String toString() {
        return "SellDetail{" +
                "id=" + id +
                ", sellName='" + sellName + '\'' +
                ", sellPrice=" + sellPrice +
                ", sellCount=" + sellCount +
                ", sellTime=" + sellTime +
                ", medid=" + medid +
                ", userid=" + userid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public int getMedid() {
        return medid;
    }

    public void setMedid(int medid) {
        this.medid = medid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
