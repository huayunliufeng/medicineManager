package com.zhong.mapper;

import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.utils.Page;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName MedicineMapper
 * @Description TODO
 * @Date 2021/7/15 16:30
 * @packageName com.zhong.mapper
 */
public interface MedicineMapper {
    /**
     *添加药品
     *
     * @param medicine medicine
     */
    void addMedicine(Medicine medicine);

    /**
     * 查询所有药品
     *
     * @return Page<Medicine>
     */
    List<Medicine> findAllMedicine();

    /**
     * 查询该编号是否存在
     *
     * @param medNo medNo
     * @return int
     */
    int getMedicineByMedNo(String medNo);


}
