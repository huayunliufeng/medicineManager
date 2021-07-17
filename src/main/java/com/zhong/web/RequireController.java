package com.zhong.web;

import com.zhong.po.Require;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 华韵流风
 * @ClassName RequireController
 * @Description TODO
 * @Date 2021/7/17 17:15
 * @packageName com.zhong.web
 */
@Controller
@RequestMapping("/req")
public class RequireController {

    @PostMapping(value = "addReq")
    public ModelAndView addRequire(Require require) {


        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "添加成功！");
        mav.setViewName("info");
        return mav;
    }

}
