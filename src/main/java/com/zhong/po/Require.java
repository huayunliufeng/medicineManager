package com.zhong.po;

/**
 * @author 华韵流风
 * @ClassName Require
 * @Description TODO
 * @Date 2021/7/17 16:46
 * @packageName com.zhong.po
 */
public class Require {
    private Integer id;
    private String medNo;
    private String medName;
    private String medPrice;
    private Integer reqCount;
    private String factoryAdd;
    private String photoPath;
    private String description;
    private Integer categoryId;

    public Require() {
    }

    public Require(Integer id, String medNo, String medName, String medPrice, Integer reqCount, String factoryAdd, String photoPath, String description, Integer categoryId) {
        this.id = id;
        this.medNo = medNo;
        this.medName = medName;
        this.medPrice = medPrice;
        this.reqCount = reqCount;
        this.factoryAdd = factoryAdd;
        this.photoPath = photoPath;
        this.description = description;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Require{" +
                "id=" + id +
                ", medNo='" + medNo + '\'' +
                ", medName='" + medName + '\'' +
                ", medPrice='" + medPrice + '\'' +
                ", reqCount=" + reqCount +
                ", factoryAdd='" + factoryAdd + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedNo() {
        return medNo;
    }

    public void setMedNo(String medNo) {
        this.medNo = medNo;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedPrice() {
        return medPrice;
    }

    public void setMedPrice(String medPrice) {
        this.medPrice = medPrice;
    }

    public Integer getReqCount() {
        return reqCount;
    }

    public void setReqCount(Integer reqCount) {
        this.reqCount = reqCount;
    }

    public String getFactoryAdd() {
        return factoryAdd;
    }

    public void setFactoryAdd(String factoryAdd) {
        this.factoryAdd = factoryAdd;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
