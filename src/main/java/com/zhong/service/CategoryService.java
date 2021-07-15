package com.zhong.service;

import com.zhong.po.Category;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName CategoryService
 * @Description TODO
 * @Date 2021/7/15 10:27
 * @packageName com.zhong.service
 */

public interface CategoryService {

    /**
     * 查询所有的分类
     *
     * @return List<Category>
     */
    List<Category> findAllCategory();
}
