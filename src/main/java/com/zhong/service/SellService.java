package com.zhong.service;

import com.zhong.po.SellDetail;

/**
 * @author 华韵流风
 * @ClassName SellService
 * @Description TODO
 * @Date 2021/7/15 10:27
 * @packageName com.zhong.service
 */
public interface SellService {

    /**
     * 添加订单
     *
     * @param sellDetail sellDetail
     */
    void addSellDetail(SellDetail sellDetail);
}
