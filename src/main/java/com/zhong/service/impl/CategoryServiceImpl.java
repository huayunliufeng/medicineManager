package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.CategoryMapper;
import com.zhong.po.Category;
import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
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


    public List<Category> findAllCategory() {
        return categoryMapper.findAllCategory();
    }

    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    public int  getCategoryByName(String name) {
        return categoryMapper.getCategoryByName(name);
    }


    public Page<Category> findCategory(QueryVo vo) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Category> categories = categoryMapper.findCategory();
        //得到分页后的最终结果
        PageInfo<Category> pageInfo = new PageInfo<Category>(categories);

        return new Page<Category>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    public void deleteCategoryById(String id) {
        categoryMapper.deleteCategoryById(id);
    }

    public Category findOneCategory(String id) {
        return categoryMapper.findOneCategory(id);
    }

    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }
}
