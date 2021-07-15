package com.zhong.po;

/**
 * @author 华韵流风
 * @ClassName Medicine
 * @Description TODO
 * @Date 2021/7/15 9:47
 * @packageName com.zhong.po
 */
public class Medicine {

    private int id;
    private String medNo;
    private String name;
    private String factoryAdd;
    private String description;
    private double price;
    private int medCount;
    private String photoPath;
    private int categoryId;

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medNo='" + medNo + '\'' +
                ", name='" + name + '\'' +
                ", factoryAdd='" + factoryAdd + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", medCount=" + medCount +
                ", photoPath='" + photoPath + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedNo() {
        return medNo;
    }

    public void setMedNo(String medNo) {
        this.medNo = medNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactoryAdd() {
        return factoryAdd;
    }

    public void setFactoryAdd(String factoryAdd) {
        this.factoryAdd = factoryAdd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMedCount() {
        return medCount;
    }

    public void setMedCount(int medCount) {
        this.medCount = medCount;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
