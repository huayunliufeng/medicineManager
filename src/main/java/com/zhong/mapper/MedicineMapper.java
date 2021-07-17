package com.zhong.mapper;

import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
import com.zhong.utils.Page;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 高级查询
     * @param medicine medicine
     * @return list
     */

    List<Medicine> findMedByMore(Medicine medicine);


    /**
     * 删除药品
     *
     * @param id id
     */
    void deleteMedicineById(String id);

    /**
     *
     * 库存的查询
     * @param type int值（0,1,-1)
     * @param medCount 输入的查询条件
     * @return List
     */

    List<Medicine> findMedInventory(@Param("type") int type, @Param("medCount") int medCount);

}
