package com.zhong.service.impl;

import com.zhong.mapper.RequireMapper;
import com.zhong.po.Require;
import com.zhong.service.RequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 华韵流风
 * @ClassName RequireServiceImpl
 * @Description TODO
 * @Date 2021/7/17 17:18
 * @packageName com.zhong.service.impl
 */
@Service
public class RequireServiceImpl implements RequireService {

    @Autowired
    private RequireMapper requireMapper;

    @Override
    public void addRequire(Require require) {
        requireMapper.addRequire(require);
    }
}
