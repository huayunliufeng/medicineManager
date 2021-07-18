package com.zhong.web;

import com.zhong.po.AdminUser;
import com.zhong.po.QueryVo;
import com.zhong.service.UserService;
import com.zhong.utils.Page;
import com.zhong.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * @author 华韵流风
 * @ClassName UserController
 * @Description TODO
 * @Date 2021/7/15 9:56
 * @packageName com.zhong.web
 * 管理员管理
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 校验账号
     *
     * @param username username
     * @return String
     */
    @GetMapping(value = "getUser")
    @ResponseBody
    public String getAdminUser(String username){
        Integer count = userService.getAdminUser(username);
        boolean isMatches = Pattern.matches("^[A-Za-z]\\w+", username);
        if(!isMatches){
            return "ERROR";
        }
        if(count != 0){
            return "YES";
        }
        return "NO";
    }

    /**
     * 校验原密码
     *
     * @param password password
     * @param id id
     * @return String
     */
    @PostMapping(value = "getPass")
    @ResponseBody
    public String getPass(String password,String id){
        password = Tools.md5(password);
        String rightPass = userService.getPassword(id);

        if(password.equals(rightPass)){
            return "YES";
        }else {
            return "NO";
        }
    }

    /**
     * 添加管理员
     *
     * @param adminUser adminUser
     * @return String
     */
    @PostMapping(value = "addUser")
    public String addAdminUser(AdminUser adminUser){
        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        adminUser.setCreateTime(createTime);
        userService.addAdminUser(adminUser);
        return "redirect:/user/findUser";
    }

    /**
     * 查询所有管理员
     *
     * @param vo vo
     * @param model model
     * @return String
     */
    @GetMapping(value = "/findUser")
    public String findAllAdminUser(QueryVo vo,Model model){
        Page<AdminUser> adminUsers = userService.findAllAdminUser(vo);
        model.addAttribute("page", adminUsers);
        model.addAttribute("url", "findUser");
        return "system/user_list";
    }


    /**
     * 删除管理员
     *
     * @param id id
     * @return String
     */
    @GetMapping(value = "/delUser/{id}")
    public String deleteAdminUser(@PathVariable String id){
        userService.deleteAdminUserById(id);
        return "redirect:/user/findUser";
    }

    /**
     * 修改密码
     *
     * @param id id
     * @param newPass newPass
     * @return ModelAndView
     */
    @PostMapping(value = "/updateUser")
    public ModelAndView updateAdminUserById(String id,String newPass){
        userService.updateAdminUserPassword(id, newPass);
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "修改密码成功！");
        mav.setViewName("info");
        return mav;
    }


}
