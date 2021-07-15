package com.zhong.web;

import com.zhong.po.Category;
import com.zhong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName MainController
 * @Description TODO
 * @Date 2021/7/15 10:11
 * @packageName com.zhong.web
 * 登录
 */
@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/toMain")
    public String getMainView(){
        return "manager";
    }

    @GetMapping(value = "/toTop")
    public String getTop(){
        return "top";
    }

    @GetMapping(value = "/toLeft")
    public String getLeft(){
        return "left";
    }

    /*@GetMapping(value = "toMedList")
    public String getMedList(){
        return "forward:/med/findMed";
    }*/

    @GetMapping(value = "/toCate")
    public String getCategory(Model model){
        List<Category> categorys = categoryService.findAllCategory();
        model.addAttribute("categorys", categorys);
        return "baseData/med_save";
    }

}
