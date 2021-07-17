package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.MedicineMapper;
import com.zhong.po.Medicine;
import com.zhong.po.QueryVo;
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
        List<Medicine> medicines = medicineMapper.findMedicines(keyWord);
        //得到分页后的最终结果
        PageInfo<Medicine> pageInfo = new PageInfo<Medicine>(medicines);

        return new Page<Medicine>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }


    @Override
    public void addMedicine(Medicine medicine) {
        medicineMapper.addMedicine(medicine);
    }

    @Override
    public int getMedicineByMedNo(String medNo) {
        return medicineMapper.getMedicineByMedNo(medNo);
    }

    @Override
    public Medicine findOneMedicine(String id) {
        return medicineMapper.findOneMedicine(id);
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        medicineMapper.updateMedicine(medicine);
    }

    @Override
    public Page<Medicine> findMedByMore(QueryVo vo, Medicine medicine) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Medicine> medicines = medicineMapper.findMedByMore(medicine);
        //得到分页后的最终结果
        PageInfo<Medicine> pageInfo = new PageInfo<Medicine>(medicines);

        return new Page<Medicine>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public void deleteMedicineById(String id) {
        medicineMapper.deleteMedicineById(id);
    }

    public Page<Medicine> findMedInventory(QueryVo vo, int type,int medCount) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Medicine> medicines = medicineMapper.findMedInventory(type,medCount);
        //得到分页后的最终结果
        PageInfo<Medicine> pageInfo = new PageInfo<Medicine>(medicines);

        return new Page<Medicine>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

}
