package com.zhong.web;

import com.zhong.po.AdminUser;
import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.po.SellDetail;
import com.zhong.service.MedicineService;
import com.zhong.service.SellService;
import com.zhong.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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
    @Autowired
    private MedicineService medicineService;

    /**
     * 购买药品
     *
     * @param sellDetail sellDetail
     * @return ModelAndView
     */
    @PostMapping(value = "/buyMed")
    public ModelAndView buyMedicine(SellDetail sellDetail) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        AdminUser user = (AdminUser) request.getServletContext().getAttribute("user");

        sellDetail.setUserid(user.getId());
        sellDetail.setSellTime(new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime()));
        sellService.addSellDetail(sellDetail);

        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "购买成功！");
        mav.setViewName("info");
        return mav;
    }

    /**
     * 查询所有sell
     *
     * @param vo        vo
     * @param model     model
     * @param queryPage queryPage
     * @return String
     */
    @GetMapping(value = "/findSellList")
    public String findSellList(QueryVo vo, Model model, String queryPage) {
        Page<SellDetail> sellDetails = sellService.findSellDetails(vo, null);
        model.addAttribute("page", sellDetails);
        model.addAttribute("url", "findSellList");
        return "sell/" + queryPage;
    }

    /**
     * 按名称模糊查询
     *
     * @param vo        vo
     * @param model     model
     * @param keyWord   keyWord
     * @param queryPage queryPage
     * @return String
     */
    @GetMapping(value = "/fuQue")
    public String fuzzyQuery(Model model, String keyWord, QueryVo vo, String queryPage) {
        Page<SellDetail> sellDetails = sellService.findSellDetails(vo, keyWord.trim());
        model.addAttribute("page", sellDetails);
        model.addAttribute("url", "fuQue");
        return "sell/" + queryPage;
    }

    /**
     * 查询药品详细信息
     *
     * @param model model
     * @param id    id
     * @return String
     */
    @GetMapping(value = "/findMedDet/{id}")
    public String findMedDetail(Model model, @PathVariable String id) {
        Medicine medicine = medicineService.findOneMedicine(id);
        model.addAttribute("medicine", medicine);
        return "baseData/med_view";
    }

    /**
     * 按时间查询订单
     *
     * @param vo vo
     * @param begin begin
     * @param end end
     * @param model model
     * @param queryPage queryPage
     * @return String
     */
    @GetMapping(value = "/findSellByData")
    public String findSellByData(QueryVo vo, String begin, String end, Model model, String queryPage) {
        Page<SellDetail> sellDetails = sellService.findSellByData(vo, begin, end);
        model.addAttribute("page", sellDetails);
        model.addAttribute("url", "findSellByData");
        return "sell/" + queryPage;
    }

    @GetMapping(value = "/delSell/{id}")
    public ModelAndView deleteSellById(@PathVariable String id){
        sellService.deleteSellById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", "删除成功！");
        mav.setViewName("info");
        return mav;
    }


}
