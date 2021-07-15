package com.zhong.service;

import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.utils.Page;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName MedicineService
 * @Description TODO
 * @Date 2021/7/15 10:27
 * @packageName com.zhong.service
 */
public interface MedicineService {

    /**
     *添加药品
     *
     * @param medicine medicine
     */
    void addMedicine(Medicine medicine);

    /**
     * 查询所有药品
     *
     * @param vo vo
     * @return Page<Medicine>
     */
    Page<Medicine> findAllMedicine(QueryVo vo);

    /**
     * 查询该编号是否存在
     *
     * @param medNo medNo
     * @return int
     */
    int getMedicineByMedNo(String medNo);


}
