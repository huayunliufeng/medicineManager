package com.zhong.web;

import com.zhong.po.AdminUser;
import com.zhong.po.Category;
import com.zhong.service.CategoryService;
import com.zhong.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }

    /**
     * 来判断输入的用户名是否正确
     *
     * @return 进入or重新输入
     */
    @PostMapping(value = "/userLogin")
    public String userLoginFilter(String username, String password) {
        AdminUser user = mainService.userLogin(username, password);
        if (user != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            request.getServletContext().setAttribute("user", user);
            return "manager";
        } else {
            return "login";
        }
    }

    @GetMapping(value = "/toTop")
    public String getTop() {
        return "top";
    }

    @GetMapping(value = "/toLeft")
    public String getLeft() {
        return "left";
    }

    @GetMapping(value = "/toCate")
    public String getCategory(Model model) {
        List<Category> categorys = categoryService.findAllCategory();
        model.addAttribute("categorys", categorys);
        return "baseData/med_save";
    }

}
