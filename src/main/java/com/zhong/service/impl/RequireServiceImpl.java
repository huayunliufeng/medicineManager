package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.RequireMapper;
import com.zhong.po.Category;
import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.po.Require;
import com.zhong.service.RequireService;
import com.zhong.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int getRequireByMedNo(String medNo) {
        return requireMapper.getRequireByMedNo(medNo);
    }

    @Override
    public Page<Require> findAllRequire(QueryVo vo) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Require> require = requireMapper.findAllRequire();
        //得到分页后的最终结果
        PageInfo<Require> pageInfo = new PageInfo<Require>(require);

        return new Page<Require>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }


    /**
     * 模糊查询的需求
     */
    @Override
    public Page<Require> findRequire(QueryVo vo, String keyWord) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Require> require = requireMapper.findRequire(keyWord);
        //得到分页后的最终结果
        PageInfo<Require> pageInfo = new PageInfo<Require>(require);

        return new Page<Require>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteRequireById(String id) {
        requireMapper.deleteRequireById(id);
    }

    @Override
    public Require findOneReqById(String id) {
        return requireMapper.findOneReqById(id);
    }

    @Override
    public void updateReq(Require require) {
        requireMapper.updateReq(require);
    }

    @Override
    public Require findOneReqByMedNo(String medNo) {
        return requireMapper.findOneReqByMedNo(medNo);
    }

    @Override
    public void updateReqCount(String medNo, int reqCount) {
        requireMapper.updateReqCount(medNo,reqCount);
    }


}
