package com.zhong.web;

import com.zhong.po.*;
import com.zhong.service.CategoryService;
import com.zhong.utils.BeanUtil;
import com.zhong.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * @author 华韵流风
 * @ClassName Controller
 * @Description TODO
 * @Date 2021/7/15 1:19
 * @packageName com.zhong.web
 * 分类管理
 */
@Controller
@RequestMapping("/cate")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 添加新的类别
     *
     * @param request requset
     * @return ModelAndView
     */
    @PostMapping(value = "/addCategory")
    public ModelAndView addCategory(HttpServletRequest request) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime());


        Category category = BeanUtil.toBean(request.getParameterMap(), Category.class);
        category.setCreateTime(time);

        try {
            categoryService.addCategory(category);
        } catch (Exception e) {
            throw new InsertException("新增分类失败！");
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "添加成功！");
        mav.setViewName("info");
        return mav;
    }

    /**
     * 检查药品类别名称是否重复
     */
    @GetMapping(value = "/checkCategoryName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String checkCategoryName(String name) {
        //检查格式：字母加数字
        String pattern = "^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$";
        boolean isMatch = Pattern.matches(pattern, name);
        if (!isMatch) {
            return "ERROR";
        }

        int count = categoryService.getCategoryByName(name);

        if (count == 0) {
            return "NO";
        } else {
            return "YES";
        }
    }

    /**
     * 查询所有分类
     *
     * @param model model
     * @param vo vo
     * @return String
     */
    @GetMapping(value = "/findCategory")
    public String findCategory(Model model, QueryVo vo) {
        Page<Category> categorys;
        try {
            categorys = categoryService.findCategory(vo);
        } catch (Exception e) {
            throw new SelectException("查询分类失败！");
        }

        model.addAttribute("page", categorys);
        model.addAttribute("url", "findCategory");
        return "baseData/category_list";
    }

    /**
     * 删除类别
     *
     * @param id id
     * @return ModelAndView
     */
    @GetMapping(value = "/deleteCategory/{id}")
    public ModelAndView deleteCategoryById(@PathVariable String id) {

        try {
            categoryService.deleteCategoryById(id);
        } catch (Exception e) {
            throw new DeleteException("删除分类失败！请检查是否含有该分类的药品！");
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "删除成功！");
        mav.setViewName("info");
        return mav;
    }


    /**
     * 查询要修改的分类详细信息
     *
     * @param id id
     * @param model model
     * @param resPage resPage
     * @return String
     */
    @GetMapping(value = "/findOneCategory/{id}")
    public String findOneMed(@PathVariable String id, Model model, String resPage) {
        Category category;
        try {
            category = categoryService.findOneCategory(id);
        } catch (Exception e) {
            throw new SelectException("查询id为" + id + "的分类失败！");
        }

        model.addAttribute("category", category);
        return resPage;
    }

    /**
     * 修改药品的类别
     *
     * @param category category
     * @return ModeAndView
     */
    @PostMapping(value = "/updateCategory")
    public ModelAndView updateCategory(Category category) {
        try{
            categoryService.updateCategory(category);
        }catch (Exception e){
            throw new UpdateException("更新药品类别失败！");
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "更新成功！");
        mav.setViewName("info");
        return mav;
    }


}
