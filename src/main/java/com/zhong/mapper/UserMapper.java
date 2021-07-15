package com.zhong.mapper;

import com.zhong.po.AdminUser;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName Mapper
 * @Description TODO
 * @Date 2021/7/15 1:21
 * @packageName com.zhong.mapper
 */
public interface UserMapper {



    /**
     * 添加管理员
     *
     * @param user user
     */
    void addAdminUser(AdminUser user);

    /**
     * 删除管理员
     *
     * @param id id
     */
    void deleteAdminUserById(String id);

    /**
     * 更改密码
     *
     * @param id id
     * @param newPass new Pass
     */
    void updateAdminUserPassword(String id,String newPass);

    /**
     * 查询所有管理员
     *
     * @return List<AdminUser>
     */
    List<AdminUser> findAllAdminUser();
}
