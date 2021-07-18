package com.zhong.service;

import com.zhong.po.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author 华韵流风
 * @ClassName MainService
 * @Description TODO
 * @Date 2021/7/15 10:28
 * @packageName com.zhong.service
 */
public interface MainService {

    /**
     * 用户登入
     * @param username username
     * @param password password
     * @return AdminUser
     */
    AdminUser userLogin ( String username, String password);
}
