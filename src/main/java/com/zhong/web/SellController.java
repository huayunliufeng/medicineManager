package com.zhong.web;

import com.zhong.po.LoginUser;
import com.zhong.po.SellDetail;
import com.zhong.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import com.zhong.po.AdminUser;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;


/**
 * @author 华韵流风
 * @ClassName SellController
 * @Description TODO
 * @Date 2021/7/15 9:56
 * @packageName com.zhong.web
 * 销售管理
 */
@Controller
@RequestMapping("/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    @PostMapping(value = "/buyMed")
    public ModelAndView buyMedicine(SellDetail sellDetail) {

        sellDetail.setUserid(LoginUser.getUser().getId());
        sellDetail.setSellTime(Calendar.getInstance().getTime());
        sellService.addSellDetail(sellDetail);



        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "购买成功！");
        mav.setViewName("info");
        return mav;
    }

}
