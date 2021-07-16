package com.zhong.mapper;

import com.zhong.po.Medicine;

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
     * @param keyWord keyWord
     * @return Page<Medicine>
     */
    List<Medicine> findMedicines(String keyWord);

    /**
     * 查询该编号是否存在
     *
     * @param medNo medNo
     * @return int
     */
    int getMedicineByMedNo(String medNo);

    /**
     * 查询单个药品
     *
     * @param id id
     * @return Medicine
     */
    Medicine findOneMedicine(String id);

    /**
     * 更新药品
     *
     * @param medicine medicine
     */
    void updateMedicine(Medicine medicine);



    List<Medicine> findMedByMore(Medicine medicine);

}
