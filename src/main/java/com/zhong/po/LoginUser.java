package com.zhong.po;

/**
 * @author 华韵流风
 * @ClassName LoginUser
 * @Description TODO
 * @Date 2021/7/16 19:52
 * @packageName com.zhong.po
 */
public class LoginUser {
    private static AdminUser user;

    public static AdminUser getUser() {
        return user;
    }

    public static void setUser(AdminUser user) {
        LoginUser.user = user;
    }

}
