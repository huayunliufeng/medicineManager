package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.SellMapper;
import com.zhong.po.*;
import com.zhong.service.SellService;
import com.zhong.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void addSellDetail(SellDetail sellDetail) {
        try {
            sellMapper.addSellDetail(sellDetail);
        } catch (Exception e) {
            throw new InsertException("添加订单失败！");
        }

    }

    @Override
    public Page<SellDetail> findSellDetails(QueryVo vo, String keyWord) {
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<SellDetail> sellDetails;
        try {
            sellDetails = sellMapper.findSellDetails(keyWord);
        } catch (Exception e) {
            throw new SelectException("查询keyWord为 " + keyWord + " 的订单失败！");
        }
        PageInfo<SellDetail> pageInfo = new PageInfo<SellDetail>(sellDetails);
        return new Page<SellDetail>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public Page<SellDetail> findSellByData(QueryVo vo, String begin, String end) {
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<SellDetail> sellDetails;
        try {
            sellDetails = sellMapper.findSellByData(begin, end);
        } catch (Exception e) {
            throw new SelectException("查询日期在 " + begin + " - " + end + " 的订单失败！");
        }
        PageInfo<SellDetail> pageInfo = new PageInfo<SellDetail>(sellDetails);
        return new Page<SellDetail>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteSellById(String id) {
        try {
            sellMapper.deleteSellById(id);
        } catch (Exception e) {
            throw new DeleteException("删除订单失败！");
        }

    }

    @Override
    public Medicine findOneMedicineById(String id) {
        Medicine medicine;
        try {
            medicine = sellMapper.findOneMedicineById(id);
            return medicine;
        } catch (Exception e) {
            throw new SelectException("查询id为 " + id + " 的药品信息失败！");
        }

    }
}
