package com.zhong.service.impl;

import com.zhong.mapper.UserMapper;
import com.zhong.po.AdminUser;
import com.zhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2021/7/15 10:03
 * @packageName com.zhong.service.impl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void addAdminUser(AdminUser user) {

    }

    public void deleteAdminUserById(String id) {

    }

    public void updateAdminUserPassword(String id, String newPass) {

    }

    public List<AdminUser> findAllAdminUser() {
        return null;
    }
}