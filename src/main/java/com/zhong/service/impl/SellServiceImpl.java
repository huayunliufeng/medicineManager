package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.SellMapper;
import com.zhong.po.QueryVo;
import com.zhong.po.SellDetail;
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
        sellMapper.addSellDetail(sellDetail);
    }

    @Override
    public Page<SellDetail> findSellDetails(QueryVo vo, String keyWord) {
        PageHelper.startPage(vo.getPage(),vo.getRows());
        List<SellDetail> sellDetails = sellMapper.findSellDetails(keyWord);
        PageInfo<SellDetail> pageInfo = new PageInfo<SellDetail>(sellDetails);
        return new Page<SellDetail>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public Page<SellDetail> findSellByData(QueryVo vo, String begin, String end) {
        PageHelper.startPage(vo.getPage(),vo.getRows());
        List<SellDetail> sellDetails = sellMapper.findSellByData(begin,end);
        PageInfo<SellDetail> pageInfo = new PageInfo<SellDetail>(sellDetails);
        return new Page<SellDetail>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteSellById(String id) {
        sellMapper.deleteSellById(id);
    }
}
