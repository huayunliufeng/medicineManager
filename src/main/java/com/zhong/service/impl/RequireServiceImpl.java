package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.RequireMapper;
import com.zhong.po.*;
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

        try {
            requireMapper.addRequire(require);
        } catch (Exception e) {
            throw new InsertException("添加需求失败！");
        }
    }

    @Override
    public int getRequireByMedNo(String medNo) {
        int count;
        try {
            count = requireMapper.getRequireByMedNo(medNo);
            return count;
        } catch (Exception e) {
            throw new SelectException("查询编号为 " + medNo + " 的药品失败！");
        }

    }

    @Override
    public Page<Require> findAllRequire(QueryVo vo) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Require> require;
        try {
            require = requireMapper.findAllRequire();
        } catch (Exception e) {
            throw new SelectException("查询所有需求失败！");
        }
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
        List<Require> require;
        try {
            require = requireMapper.findRequire(keyWord);
        } catch (Exception e) {
            throw new SelectException("查询keyWord为 " + keyWord + " 的需求失败！");
        }
        //得到分页后的最终结果
        PageInfo<Require> pageInfo = new PageInfo<Require>(require);

        return new Page<Require>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteRequireById(String id) {
        try {
            requireMapper.deleteRequireById(id);
        } catch (Exception e) {
            throw new DeleteException("删除id为 " + id + " 的需求失败！");
        }

    }

    @Override
    public Require findOneReqById(String id) {
        Require require;
        try {
            require = requireMapper.findOneReqById(id);
            return require;
        } catch (Exception e) {
            throw new SelectException("查询id为 " + id + " 的需求失败！");
        }

    }

    @Override
    public void updateReq(Require require) {
        try {
            requireMapper.updateReq(require);
        } catch (Exception e) {
            throw new UpdateException("更新需求失败！");
        }

    }

    @Override
    public Require findOneReqByMedNo(String medNo) {
        Require require;
        try {
            require = requireMapper.findOneReqByMedNo(medNo);
            return require;
        } catch (Exception e) {
            throw new SelectException("查询medNo为 " + medNo + " 的需求失败！");
        }

    }

    @Override
    public void updateReqCount(String medNo, int reqCount) {
        try {
            requireMapper.updateReqCount(medNo, reqCount);
        } catch (Exception e) {
            throw new UpdateException("更新需求失败！");
        }
    }

}
