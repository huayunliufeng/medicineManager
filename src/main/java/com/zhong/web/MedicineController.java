package com.zhong.web;

import com.zhong.po.Medicine;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping(value = "/addMed")
    public void addMedicine(Medicine medicine){



    }


}
