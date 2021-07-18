package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.CategoryMapper;
import com.zhong.po.*;
import com.zhong.service.CategoryService;
import com.zhong.utils.Page;
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


    @Override
    public List<Category> findAllCategory() {
        List<Category> list;
        try {
            list = categoryMapper.findAllCategory();
            return list;
        }catch (Exception e){
            throw new SelectException("查询所有分类失败！");
        }

    }

    @Override
    public void addCategory(Category category) {
        try {
            categoryMapper.addCategory(category);
        }catch (Exception e){
            throw new InsertException("添加分类失败！");
        }

    }

    @Override
    public int  getCategoryByName(String name) {
        int count;
        try {
           count = categoryMapper.getCategoryByName(name);
           return count;
        }catch (Exception e){
            throw new InsertException("获取分类数量失败！");
        }
    }


    @Override
    public Page<Category> findCategory(QueryVo vo) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Category> categories;
        try {
            categories = categoryMapper.findCategory();
        }catch (Exception e){
            throw new SelectException("查询分类失败！");
        }
        //得到分页后的最终结果
        PageInfo<Category> pageInfo = new PageInfo<Category>(categories);

        return new Page<Category>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteCategoryById(String id) {
        try {
            categoryMapper.deleteCategoryById(id);
        }catch (Exception e){
            throw new DeleteException("删除分类失败！请检查是否有该分类的药品！");
        }

    }

    @Override
    public Category findOneCategory(String id) {
        Category category;
        try {
            category = categoryMapper.findOneCategory(id);
            return category;
        }catch (Exception e){
            throw new SelectException("查询id为 "+id+" 的分类失败！");
        }

    }

    @Override
    public void updateCategory(Category category) {
        try {
            categoryMapper.updateCategory(category);
        }catch (Exception e){
            throw new UpdateException("更新分类失败！");
        }
    }
}
