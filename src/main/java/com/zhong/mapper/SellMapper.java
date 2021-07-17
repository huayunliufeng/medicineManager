package com.zhong.mapper;

import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.po.SellDetail;
import com.zhong.utils.Page;

import java.util.List;

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

    /**
     * 查询订单
     *
     * @param keyWord keyWord
     * @return List<SellDetail>
     */
    List<SellDetail> findSellDetails(String keyWord);

    /**
     * 按日期查询订单
     *
     * @param begin begin
     * @param end end
     * @return List<SellDetail>
     */
    List<SellDetail> findSellByData(String begin,String end);

    /**
     * 删除订单
     *
     * @param id id
     */
    void deleteSellById(String id);

    /**
     * 查询订单里的药品信息
     *
     * @param id id
     * @return Medicine
     */
    Medicine findOneMedicineById(String id);
}
