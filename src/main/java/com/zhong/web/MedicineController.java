package com.zhong.web;

import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.service.MedicineService;
import com.zhong.utils.BeanUtil;
import com.zhong.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author 华韵流风
 * @ClassName MedicineController
 * @Description TODO
 * @Date 2021/7/15 9:54
 * @packageName com.zhong.web
 * 药品管理
 */

@Controller
@RequestMapping("/med")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    /**
     * 添加药品
     *
     * @param request request
     * @return ModelAndView
     */
    @PostMapping(value = "/addMed")
    public ModelAndView addMedicine(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile photoPath = multipartRequest.getFile("photoPath");
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        String filename = photoPath.getOriginalFilename();

        try {
            photoPath.transferTo(new File(path, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Medicine medicine1 = BeanUtil.toBean(request.getParameterMap(), Medicine.class);
        medicine1.setPhotoPath(filename);

        medicineService.addMedicine(medicine1);
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "添加成功！");
        mav.setViewName("info");
        return mav;

    }

    /**
     * 查询分页信息
     *
     * @param model model
     * @param vo    vo
     * @return string
     */
    @GetMapping(value = "/findMed")
    public String findMedicine(Model model, QueryVo vo) {
        Page<Medicine> medicines = medicineService.findAllMedicine(vo);
        model.addAttribute("page", medicines);
        return "baseData/med_list";
    }

    /**
     * 检查药品编号是否重复
     */
    @GetMapping(value = "/checkMedNo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String checkMedNo(String medNo) {
        //检查格式：字母加数字
        String pattern = "^[A-Za-z]\\w+";
        boolean isMatch = Pattern.matches(pattern, medNo);
        if(!isMatch){
            return "ERROR";
        }

        int count = medicineService.getMedicineByMedNo(medNo);

        if(count == 0){
            return "NO";
        }
        else{
            return "YES";
        }

    }


}
