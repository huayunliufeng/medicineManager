package com.zhong.web;

import com.zhong.po.Category;
import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.po.SelectException;
import com.zhong.service.CategoryService;
import com.zhong.service.MedicineService;
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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
    @Autowired
    private CategoryService categoryService;

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
            throw new SelectException(path + "/" + filename + "文件没找到！");
        }

        Medicine medicine = BeanUtil.toBean(request.getParameterMap(), Medicine.class);
        medicine.setPhotoPath(filename);

        medicineService.addMedicine(medicine);

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
    public String findMedicine(Model model, QueryVo vo, String resPage) {
        Page<Medicine> medicines;
        medicines = medicineService.findMedicines(vo, null);
        model.addAttribute("page", medicines);
        model.addAttribute("url", "findMed");
        return resPage;
    }

    /**
     * 检查药品编号是否重复
     */
    @GetMapping(value = "/checkMedNo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String checkMedNo(String medNo) {
        //检查格式：字母加数字
        boolean isMatch = Pattern.matches("^[A-Za-z]\\w+", medNo);
        if (!isMatch) {
            return "ERROR";
        }

        int count = medicineService.getMedicineByMedNo(medNo);

        if (count == 0) {
            return "NO";
        } else {
            return "YES";
        }

    }

    /**
     * 查询药品详情
     *
     * @param id      id
     * @param model   model
     * @param resPage resPage
     * @return String
     */
    @GetMapping(value = "/findOneMed/{id}")
    public String findOneMed(@PathVariable String id, Model model, String resPage) {
        Medicine medicine;
        medicine = medicineService.findOneMedicine(id);
        model.addAttribute("medicine", medicine);
        return resPage;
    }

    /**
     * 更新药品
     *
     * @param medicine medicine
     * @return ModelAndView
     */
    @PostMapping(value = "/updateMed")
    public ModelAndView updateMedicine(Medicine medicine) {
        medicineService.updateMedicine(medicine);

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "更新成功！");
        mav.setViewName("info");
        return mav;

    }

    /**
     * 模糊查询
     *
     * @param model     model
     * @param keyWord   keyWord
     * @param vo        vo
     * @param queryPage queryPage
     * @return String
     */
    @GetMapping(value = "/fuQue")
    public String fuzzyQuery(Model model, String keyWord, QueryVo vo, String queryPage) {
        Page<Medicine> medicines;
        medicines = medicineService.findMedicines(vo, keyWord.trim());
        model.addAttribute("page", medicines);
        model.addAttribute("url", "fuQue");
        return "baseData/" + queryPage;
    }


    /**
     * 高级查询
     *
     * @param model     model
     * @param vo        vo
     * @param medicine  medicine
     * @param queryPage queryPage
     * @return String
     */
    @GetMapping(value = "/findByMore")
    public String findMedByMedMoreConditions(Model model, QueryVo vo, Medicine medicine, String queryPage) {

        medicine.setMedNo(medicine.getMedNo().trim());
        medicine.setName(medicine.getName().trim());
        medicine.setDescription(medicine.getDescription().trim());
        medicine.setFactoryAdd(medicine.getFactoryAdd().trim());

        Page<Medicine> medicineList;
        medicineList = medicineService.findMedByMore(vo, medicine);
        model.addAttribute("page", medicineList);
        model.addAttribute("url", "findByMore");
        return "baseData/" + queryPage;
    }

    /**
     * 删除药品
     *
     * @param id id
     * @return ModelAndView
     */
    @GetMapping(value = "/delMed/{id}")
    public ModelAndView deleteMedicine(@PathVariable String id) {

        medicineService.deleteMedicineById(id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "删除成功！");
        mav.setViewName("info");
        return mav;
    }

    /**
     * 得到分类信息
     *
     * @param medNo medNo
     * @param model model
     * @return String
     */
    @PostMapping(value = "getSave")
    public String getSave(String medNo, Model model) {
        List<Category> categorys;
        categorys = categoryService.findAllCategory();
        model.addAttribute("categorys", categorys);
        model.addAttribute("medNo", medNo);
        return "require/req_save";
    }

    /**
     * 渲染药品图片
     *
     * @param path     path
     * @param request  request
     * @param response response
     */
    @GetMapping(value = "/drawImg")
    public void drawImg(String path, HttpServletRequest request, HttpServletResponse response) {
        String absolutePath = request.getServletContext().getRealPath("/WEB-INF/upload/");
        //得到图片的绝对路径
        String filePath = absolutePath + "/" + path;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ServletOutputStream os = response.getOutputStream();
            int len;
            byte[] b = new byte[1024];
            while ((len = fis.read(b)) != -1) {
                os.write(b, 0, len);
            }
            os.flush();
            os.close();
            fis.close();
        } catch (Exception e) {
            throw new SelectException("文件没找到！" + filePath);
        }
    }

    /**
     * 查看库存
     *
     * @param vo        vo
     * @param type      type
     * @param medCount  medCount
     * @param model     model
     * @param queryPage queryPage
     * @return String
     */
    @GetMapping(value = "findInventory")
    public String findInventory(QueryVo vo, int type, int medCount, Model model, String queryPage) {
        Page<Medicine> medicines;
        medicines = medicineService.findMedInventory(vo, type, medCount);
        model.addAttribute("page", medicines);
        model.addAttribute("url", "findInventory");
        return "baseData/" + queryPage;
    }


}
