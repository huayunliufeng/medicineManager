package com.zhong.web;

import com.zhong.po.*;
import com.zhong.service.CategoryService;
import com.zhong.service.MedicineService;
import com.zhong.service.RequireService;
import com.zhong.utils.BeanUtil;
import com.zhong.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

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

    @Autowired
    private RequireService requireService;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private CategoryService categoryService;


    /**
     * 添加新的需求
     * @param request request
     * @return ModelAndView
     */

    @PostMapping(value = "/addReq")
    public ModelAndView addRequire(HttpServletRequest request) {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile photoPath = multipartRequest.getFile("photoPath");
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        String filename = photoPath.getOriginalFilename();

        try {
            photoPath.transferTo(new File(path, filename));
        } catch (IOException e) {
            throw new SelectException(path + "/" + filename + "文件没找到！");
        }

        Require require = BeanUtil.toBean(request.getParameterMap(), Require.class);
        require.setPhotoPath(filename);

        try {
            requireService.addRequire(require);
        } catch (Exception e) {
            throw new InsertException("添加需求失败！");
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "添加成功！");
        mav.setViewName("info");
        return mav;
    }


    /**
     * 判断需求是否重复
     * @param medNo medNo
     * @return String
     */
    @GetMapping(value = "/requireCheckMedNo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String requireCheckMedNo(String medNo,Model model) {
        //检查格式：字母加数字
        String pattern = "^[A-Za-z]\\w+";
        boolean isMatch = Pattern.matches(pattern, medNo);
        if (!isMatch) {
            return "ERROR";
        }

        //这个应该在药品表里查

        int count = medicineService.getMedicineByMedNo(medNo);

        if (count == 0) {
            return "NO";
        }else {
            return "YES";
        }

    }

    @GetMapping(value = "iflu")
    public String fuck(String medNo,Model model,QueryVo vo){
        List<Category> category = categoryService.findAllCategory();
        model.addAttribute("medNo",medNo);
        model.addAttribute("categorys",category);
        return "require/req_save";
    }

    /**
     * 修改数量
     * @param medNo medNo
     * @param reqCount reqCount
     * @return ModelAndView
     */
    @PostMapping(value = "/updateReqCount")
    public ModelAndView updateReqCount(String medNo , int reqCount){

        try {
            requireService.updateReqCount(medNo,reqCount);
        } catch (Exception e) {
            throw new UpdateException("更新异常");
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "更新成功！");
        mav.setViewName("info");
        return mav;
    }


    /**
     * 查询所有的需求
     * @param model model
     * @param vo vo
     * @return  String
     */
    @GetMapping(value = "/findAllReq")
    public String findAllRequire(Model model, QueryVo vo){
        Page<Require> requires;
        try {
            requires = requireService.findAllRequire(vo);
        } catch (Exception e) {
            throw new SelectException("查询分类失败！");
        }

        model.addAttribute("page", requires);
        model.addAttribute("url", "findCategory");
        return "require/req_list";
    }

    /**
     * 模糊查询
     * @param model model
     * @param keyWord keyWord
     * @param vo vo
     * @param queryPage queryPage
     * @return String
     */

    @GetMapping(value = "reqFuQue")
    public String requireFuzzyQuery(Model model, String keyWord, QueryVo vo, String queryPage){

        Page<Require> requires;
        try {
           requires = requireService.findRequire(vo, keyWord.trim());
        } catch (Exception e) {
            throw new SelectException("关键词为：" + keyWord + " 的查询失败！");
        }
        model.addAttribute("page", requires);
        model.addAttribute("url", "reqFuQue");
        return "require/" + queryPage;
    }

    /**
     * 删除对应的需求数据
     * @param id id
     * @return ModelAndView
     */
    @GetMapping(value = "/delReq/{id}")
    public ModelAndView deleteRequireById(@PathVariable String id){

        try {
            requireService.deleteRequireById(id);
        } catch (Exception e) {
            throw new DeleteException("id为" + id + "的需求删除失败！");
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "删除成功！");
        mav.setViewName("info");
        return mav;
    }

    /**
     * 查询药品详情
     * @param id      id
     * @param model   model
     * @param resPage resPage
     * @return String
     */
    @GetMapping(value = "/findOneReq/{id}")
    public String findOneReqById(@PathVariable String id, Model model, String resPage) {
        Require  requires;
        try {
           requires = requireService.findOneReqById(id);
        } catch (Exception e) {
            throw new SelectException("查询该需求信息失败！");
        }
        model.addAttribute("requires",requires);
        return resPage;
    }


    /**
     * 更新需求
     *
     * @param require require
     * @return ModelAndView
     */
    @PostMapping(value = "/updateReq")
    public ModelAndView updateRequire(Require require) {

        try {
           requireService.updateReq(require);
        } catch (Exception e) {
            throw new UpdateException("更新异常");
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "更新成功！");
        mav.setViewName("info");
        return mav;

    }

    @PostMapping(value = "/findReqByMedNo")
    public String findReqByMedNo (String medNo, Model model, String resPage){

        Require require;

        try {
            require = requireService.findOneReqByMedNo(medNo);
        } catch (Exception e) {
            throw new SelectException("查询该需求信息失败！");
        }
        model.addAttribute("requires",require);
        return "require/"+ resPage;
    }



}
