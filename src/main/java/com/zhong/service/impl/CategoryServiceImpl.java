package com.zhong.service.impl;

import com.zhong.mapper.CategoryMapper;
import com.zhong.po.Category;
import com.zhong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName CategoryServiceImpl
 * @Description TODO
 * @Date 2021/7/15 15:05
 * @packageName com.zhong.service.impl
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> findAllCategory() {
        return categoryMapper.findAllCategory();
    }
}
