package com.zhong.service;

import com.zhong.po.Category;
import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.utils.Page;

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

    /**
     * 添加新分类
     * @param category category
     */
    void addCategory(Category category);

    /**
     * 查询该类别名称是否存在
     *
     * @param name name
     * @return int
     */
    int getCategoryByName(String name);


    /**
     * 查所有的分类
     * @param vo vo
     * @return Page
     */

    Page<Category> findCategory(QueryVo vo);


    /**
     * 删除类别
     * @param id id
     */
    void deleteCategoryById(String id);


    /**
     * 查询单个类别
     * @param id id
     * @return category
     */
    Category findOneCategory(String id);

    /**
     * 更新药品
     * @param category category
     */
    void updateCategory(Category category);


}
