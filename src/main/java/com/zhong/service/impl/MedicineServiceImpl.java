package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.MedicineMapper;
import com.zhong.po.*;
import com.zhong.service.MedicineService;
import com.zhong.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName MedicineServiceImpl
 * @Description TODO
 * @Date 2021/7/15 16:30
 * @packageName com.zhong.service.impl
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public Page<Medicine> findMedicines(QueryVo vo, String keyWord) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Medicine> medicines;
        try {
            medicines = medicineMapper.findMedicines(keyWord);
        } catch (Exception e) {
            throw new SelectException("查询keyWord为 " + keyWord + " 的药品失败！");
        }
        //得到分页后的最终结果
        PageInfo<Medicine> pageInfo = new PageInfo<Medicine>(medicines);

        return new Page<Medicine>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }


    @Override
    public void addMedicine(Medicine medicine) {

        try {
            medicineMapper.addMedicine(medicine);
        } catch (Exception e) {
            throw new InsertException("添加药品失败！");
        }
    }

    @Override
    public int getMedicineByMedNo(String medNo) {
        int count;
        try {
            count = medicineMapper.getMedicineByMedNo(medNo);
            return count;
        } catch (Exception e) {
            throw new SelectException("获取药品失败！");
        }

    }

    @Override
    public Medicine findOneMedicine(String id) {
        Medicine medicine;
        try {
            medicine = medicineMapper.findOneMedicine(id);
            return medicine;
        } catch (Exception e) {
            throw new SelectException("查询药品详细失败！");
        }

    }

    @Override
    public void updateMedicine(Medicine medicine) {
        try {
            medicineMapper.updateMedicine(medicine);
        } catch (Exception e) {
            throw new UpdateException("更新药品信息失败");
        }

    }

    @Override
    public Page<Medicine> findMedByMore(QueryVo vo, Medicine medicine) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Medicine> medicines;
        try {
            medicines = medicineMapper.findMedByMore(medicine);
        } catch (Exception e) {
            throw new SelectException("查询失败！");
        }
        //得到分页后的最终结果
        PageInfo<Medicine> pageInfo = new PageInfo<Medicine>(medicines);

        return new Page<Medicine>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteMedicineById(String id) {
        try {
            medicineMapper.deleteMedicineById(id);
        } catch (Exception e) {
            throw new DeleteException("删除id为 " + id + " 的药品失败！");
        }

    }

    @Override
    public Page<Medicine> findMedInventory(QueryVo vo, int type, int medCount) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Medicine> medicines;
        try {
            medicines = medicineMapper.findMedInventory(type, medCount);
        } catch (Exception e) {
            throw new SelectException("查询库存失败！");
        }
        //得到分页后的最终结果
        PageInfo<Medicine> pageInfo = new PageInfo<Medicine>(medicines);

        return new Page<Medicine>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

}
