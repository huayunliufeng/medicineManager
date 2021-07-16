package com.zhong.web;

import com.zhong.po.AdminUser;
import com.zhong.po.Category;
import com.zhong.service.CategoryService;
import com.zhong.service.MainService;
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

    @Autowired
    private MainService mainService;

    @GetMapping(value = "/toLogin")
    public String getLogin(){
        return "login";
    }

    /**
     * 来判断输入的用户名是否正确
     * @return 进入or重新输入
     */
    @GetMapping(value = "/userLogin")
    public String userLoginFilter(String username,String password){
        AdminUser user = mainService.userLogin(username,password);
        if (user != null){
            return "redirect:toMain";
        }else {
            return "forward:toLogin";
        }
    }


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

    @GetMapping(value = "/toCate")
    public String getCategory(Model model){
        List<Category> categorys = categoryService.findAllCategory();
        model.addAttribute("categorys", categorys);
        return "baseData/med_save";
    }

}
