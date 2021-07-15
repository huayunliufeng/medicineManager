package com.zhong.po;

import java.util.Date;

/**
 * @author 华韵流风
 * @ClassName AdminUser
 * @Description TODO
 * @Date 2021/7/15 9:42
 * @packageName com.zhong.po
 */
public class AdminUser {
    private int id;
    private String username;
    private String password;
    private Date createTime;

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
