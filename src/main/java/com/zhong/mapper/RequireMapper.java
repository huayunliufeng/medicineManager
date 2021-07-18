package com.zhong.mapper;

import com.zhong.po.Category;
import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.po.Require;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName RequireMapper
 * @Description TODO
 * @Date 2021/7/17 17:18
 * @packageName com.zhong.mapper
 */
public interface RequireMapper {



    /**
     * 添加需求
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
     * @return List<Require>
     */
    List<Require> findAllRequire();

    /**
     * 模糊查询的需求
     * @param keyWord  keyWord
     * @return List<Require>
     */
    List<Require> findRequire(String keyWord);

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
    void updateReqCount(@Param("medNo")String medNo ,@Param("reqCount") int reqCount);




}
