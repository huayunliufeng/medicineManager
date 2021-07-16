package com.zhong.mapper;

import com.zhong.po.SellDetail;

/**
 * @author 华韵流风
 * @ClassName SellMapper
 * @Description TODO
 * @Date 2021/7/16 20:07
 * @packageName com.zhong.mapper
 */
public interface SellMapper {

    /**
     * 添加订单
     *
     * @param sellDetail sellDetail
     */
    void addSellDetail(SellDetail sellDetail);
}
