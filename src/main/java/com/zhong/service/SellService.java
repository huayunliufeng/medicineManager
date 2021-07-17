package com.zhong.service;

import com.zhong.po.QueryVo;
import com.zhong.po.SellDetail;
import com.zhong.utils.Page;

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


    /**
     * 查询订单
     *
     * @param vo vo
     * @param keyWord keyWord
     * @return Page<SellDetail>
     */
    Page<SellDetail> findSellDetails(QueryVo vo,String keyWord);

    /**
     * 按日期查询订单
     *
     * @param vo vo
     * @param begin begin
     * @param end end
     * @return Page<SellDetail>
     */
    Page<SellDetail> findSellByData(QueryVo vo,String begin,String end);

    /**
     * 删除订单
     *
     * @param id id
     */
    void deleteSellById(String id);

}
