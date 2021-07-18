package com.zhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhong.mapper.UserMapper;
import com.zhong.po.*;
import com.zhong.service.UserService;
import com.zhong.utils.Page;
import com.zhong.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 华韵流风
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2021/7/15 10:03
 * @packageName com.zhong.service.impl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addAdminUser(AdminUser user) {
        String pass = Tools.md5(user.getPassword());
        user.setPassword(pass);
        try {
            userMapper.addAdminUser(user);
        } catch (Exception e) {
            throw new InsertException("添加管理员失败！");
        }

    }

    @Override
    public void deleteAdminUserById(String id) {
        try {
            userMapper.deleteAdminUserById(id);
        } catch (Exception e) {
            throw new DeleteException("删除id为 " + id + " 的管理员失败！");
        }

    }

    @Override
    public void updateAdminUserPassword(String id, String newPass) {
        newPass = Tools.md5(newPass);
        try {
            userMapper.updateAdminUserPassword(id, newPass);
        } catch (Exception e) {
            throw new UpdateException("更新密码失败！");
        }

    }

    @Override
    public Page<AdminUser> findAllAdminUser(QueryVo vo) {
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<AdminUser> adminUsers;
        try {
            adminUsers = userMapper.findAllAdminUser();
        } catch (Exception e) {
            throw new SelectException("查询所有管理员失败！");
        }
        PageInfo<AdminUser> pageInfo = new PageInfo<AdminUser>(adminUsers);
        return new Page<AdminUser>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
    }

    @Override
    public String getPassword(String id) {
        String pass;
        try {
            pass = userMapper.getPassword(id);
            return pass;
        } catch (Exception e) {
            throw new SelectException("获取id为 " + id + " 的管理员密码失败！");
        }


    }

    @Override
    public Integer getAdminUser(String username) {
        int count;
        try {
            count = userMapper.getAdminUser(username);
            return count;
        } catch (Exception e) {
            throw new SelectException("查询用户名为 " + username + " 的管理员失败！");
        }

    }
}
