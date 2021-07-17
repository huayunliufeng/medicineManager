package com.zhong.po;

/**
 * @author 华韵流风
 * @ClassName Medicine
 * @Description TODO
 * @Date 2021/7/15 9:47
 * @packageName com.zhong.po
 */
public class Medicine {

    private Integer id;
    private String medNo;
    private String name;
    private String factoryAdd;
    private String description;
    private Double price;
    private Integer medCount;
    private Integer demand;
    private String photoPath;
    private Integer categoryId;
    private String categoryName;

    public Medicine() {
    }

    public Medicine(String medNo, String name, String factoryAdd, String description, Double price, Integer medCount, String photoPath, Integer categoryId) {
        this.medNo = medNo;
        this.name = name;
        this.factoryAdd = factoryAdd;
        this.description = description;
        this.price = price;
        this.medCount = medCount;
        this.photoPath = photoPath;
        this.categoryId = categoryId;
    }

    public Integer getDemand() {
        return demand;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMedCount() {
        return medCount;
    }

    public void setMedCount(Integer medCount) {
        this.medCount = medCount;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
