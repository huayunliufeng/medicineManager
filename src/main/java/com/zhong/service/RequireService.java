package com.zhong.service;

import com.zhong.po.QueryVo;
import com.zhong.po.Require;
import com.zhong.utils.Page;

/**
 * @author 华韵流风
 * @ClassName RequireService
 * @Description TODO
 * @Date 2021/7/17 17:18
 * @packageName com.zhong.service
 */
public interface RequireService {

    /**
     * 添加需求
     *
     * @param require require
     */
    void addRequire(Require require);



    /**
     * 查询该需求编号是否存在
     *
     * @param medNo medNo
     * @return int
     */
    int getRequireByMedNo(String medNo);


    /**
     * 查询所有的需求
     * @param vo vo
     * @return Page<Require>
     */
    Page<Require> findAllRequire(QueryVo vo);


    /**
     * 模糊查询需求
     *
     * @param vo vo
     * @param keyWord keyWord
     * @return Page<Medicine>
     */
    Page<Require> findRequire(QueryVo vo, String keyWord);


    /**
     * 删除对应的需求
     * @param id id
     */
    void deleteRequireById(String id);

    /**
     * 查询单个需求
     *
     * @param id id
     * @return Require
     */
    Require findOneReqById(String id);

    /**
     *  更新需求
     * @param require require
     */
    void updateReq(Require require);

    /**
     * 通过medNo查询需求
     * @param medNo medNo
     * @return Require
     */
    Require findOneReqByMedNo(String medNo);

    /**
     * 修改需求的数量
     * @param medNo medNo
     * @param reqCount reqCount
     */
    void updateReqCount(String medNo , int reqCount);


}
