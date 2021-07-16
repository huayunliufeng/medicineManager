package com.zhong.service.impl;

import com.zhong.mapper.SellMapper;
import com.zhong.po.SellDetail;
import com.zhong.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 华韵流风
 * @ClassName SellServiceImpl
 * @Description TODO
 * @Date 2021/7/16 20:07
 * @packageName com.zhong.service.impl
 */
@Service
public class SellServiceImpl implements SellService {

    @Autowired
    private SellMapper sellMapper;

    public void addSellDetail(SellDetail sellDetail) {
        sellMapper.addSellDetail(sellDetail);
    }
}
