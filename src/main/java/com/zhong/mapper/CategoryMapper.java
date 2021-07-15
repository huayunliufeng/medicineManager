package com.zhong.mapper;

import com.zhong.po.Category;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName CategoryMapper
 * @Description TODO
 * @Date 2021/7/15 15:05
 * @packageName com.zhong.mapper
 */
public interface CategoryMapper {

    /**
     * 查询所有的分类
     *
     * @return List<Category>
     */
    List<Category> findAllCategory();
}
