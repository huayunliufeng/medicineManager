package com.zhong.mapper;

import com.zhong.po.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author 24804
 * @ClassName MainMapper
 * @Description TOD0
 * @Date 2021/7/15下午 05:22
 * @packageName com.zhong.mapper
 */
public interface MainMapper {
    /**
     *用户登入
     * @param username
     * @param password
     * @return AdminUser
     */
    AdminUser userLogin (@Param("username") String username,@Param("password") String password);
}
