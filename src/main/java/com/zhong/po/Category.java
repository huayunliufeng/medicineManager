package com.zhong.po;

import java.util.Date;

/**
 * @author 华韵流风
 * @ClassName Category
 * @Description TODO
 * @Date 2021/7/15 9:50
 * @packageName com.zhong.po
 */
public class Category {

    private int id;
    private String name;
    private String description;
    private Date createTime;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
