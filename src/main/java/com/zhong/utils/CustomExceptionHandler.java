package com.zhong.utils;

import com.zhong.po.DeleteException;
import com.zhong.po.InsertException;
import com.zhong.po.SelectException;
import com.zhong.po.UpdateException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 华韵流风
 * @ClassName CustomExceptionHandler
 * @Description TODO
 * @Date 2021/7/15 10:20
 * @packageName com.zhong.utils
 */
public class CustomExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mav = new ModelAndView();
        if (e instanceof InsertException) {
            mav.addObject("info", e.getMessage());
        } else if (e instanceof DeleteException) {
            mav.addObject("info", e.getMessage());
        } else if (e instanceof UpdateException) {
            mav.addObject("info", e.getMessage());
        } else if (e instanceof SelectException) {
            mav.addObject("info", e.getMessage());
        } else {
            mav.addObject("info", "系统出现未知错误，请与管理员联系！");
        }
        mav.setViewName("info");
        return mav;
    }
}
