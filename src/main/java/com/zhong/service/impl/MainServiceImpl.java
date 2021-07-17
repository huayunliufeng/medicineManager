package com.zhong.service.impl;

import com.zhong.mapper.MainMapper;
import com.zhong.po.AdminUser;
import com.zhong.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 24804
 * @ClassName MainServiceImpl
 * @Description TOD0
 * @Date 2021/7/15下午 05:32
 * @packageName com.zhong.service.impl
 */
@Service
public class MainServiceImpl implements MainService {
    @Autowired
    private MainMapper mainMapper;

    @Override
    public AdminUser userLogin(String username, String password) {
        return mainMapper.userLogin(username,password);
    }
}
