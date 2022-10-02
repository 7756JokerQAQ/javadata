package com.yupi.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.usercenter.model.domain.request.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author lenovo
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2022-09-28 14:23:09
*/
public interface UserService extends IService<User> {





    /**
     * 用户注册账号
     * @param userAccount  账号
     * @param userPassword 密码
     * @param checkPassword 再次确认密码
     * @return  是否注册成功
     */
    long userRegister(String userAccount,String userPassword,String checkPassword,String planetCode);

    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    User getSafetyUser(User originUser);

    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);
}
