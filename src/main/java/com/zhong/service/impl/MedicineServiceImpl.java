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

    public Page<Medicine> findAllMedicine(QueryVo vo) {
        //设置每页显示数量
        PageHelper.startPage(vo.getPage(), vo.getRows());
        //得到所有的记录数
        List<Medicine> medicines = medicineMapper.findAllMedicine();
        //得到分页后的最终结果
        PageInfo<Medicine> pageInfo = new PageInfo<Medicine>(medicines);

        return new Page<Medicine>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }


    public void addMedicine(Medicine medicine) {
        medicineMapper.addMedicine(medicine);
    }

    public int getMedicineByMedNo(String medNo) {
        return medicineMapper.getMedicineByMedNo(medNo);
    }


}
