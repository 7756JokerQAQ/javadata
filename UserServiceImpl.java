package com.yupi.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.usercenter.common.ErrorCode;
import com.yupi.usercenter.exception.BusinessException;
import com.yupi.usercenter.model.domain.request.User;
import com.yupi.usercenter.service.UserService;
import com.yupi.usercenter.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.yupi.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
 * @author lenovo
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2022-09-28 14:23:09
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Resource
    private UserMapper userMapper;
    private static final String SALT="yupi";


    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword,String planetCode) {
    if(StringUtils.isAnyBlank(userAccount,userPassword,checkPassword,planetCode)){
        throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数为空");
    }
    if(userAccount.length()<4){
        throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户账户过短");
    }
    if(userPassword.length()<8||checkPassword.length()<8){
        throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户密码过短");
    }
    if(planetCode.length()>5){
        throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户编码过长");
    }
    //正则表达式子不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher= Pattern.compile(validPattern).matcher(userAccount);
        if(matcher.find()){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"不能包含特殊字符");
        }
        if(!userPassword.equals(checkPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"原密码与检验密码不一致");
        }

        //账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        long count=userMapper.selectCount(queryWrapper);
        if(count>0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"账号重复");
        }

        //编号不能重复
         queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("planetCode",planetCode);
         count=userMapper.selectCount(queryWrapper);
        if(count>0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户编号重复");
        }
        //加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setPlanetCode(planetCode);
        boolean saveResult=this.save(user);
        if(!saveResult){
            return -1;
        }

        return user.getId();
    }

    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        //1.校验账户是否符合规则
        if(StringUtils.isAnyBlank(userAccount,userPassword)){
            return null;
        }
        if(userAccount.length()<4){
            return null;
        }
        if(userPassword.length()<8){
            return null;
        }
        //正则表达式子不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher= Pattern.compile(validPattern).matcher(userAccount);
        if(matcher.find()){
            return null;
        }
        //加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        //查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        queryWrapper.eq("userPassword",userPassword);
        User user = userMapper.selectOne(queryWrapper);
        if(user==null){
            log.info("user login failed ,userAccount or userPassword not exit");
            return null;
        }

        //用户脱敏
        User safetyUser=getSafetyUser(user);

        //记录用户的状态
        request.getSession().setAttribute(USER_LOGIN_STATE,safetyUser);
        return safetyUser;
    }

    /**
     * 用户脱敏函数
     * @param originUser
     * @return
     */
    @Override
    public User getSafetyUser(User originUser){
       //先进性一个判断
        if(originUser==null){
            return  null;
        }
        //用户脱敏
        User safetyUser = new User();
        safetyUser.setId(originUser.getId());
        safetyUser.setUsername(originUser.getUsername());
        safetyUser.setUserAccount(originUser.getUserAccount());
        safetyUser.setAvatarUrl(originUser.getAvatarUrl());
        safetyUser.setGender(originUser.getGender());
        safetyUser.setUserPassword(originUser.getUserPassword());
        safetyUser.setEmail(originUser.getEmail());
        safetyUser.setPlanetCode(originUser.getPlanetCode());
        safetyUser.setUserStatus(originUser.getUserStatus());
        safetyUser.setUserRole(originUser.getUserRole());
        safetyUser.setPhone(originUser.getPhone());
        safetyUser.setCreateTime(originUser.getCreateTime());
        return safetyUser;
    }

    /**
     * 用户注销成功了返回1
     * @param request
     * @return
     */
    @Override
    public int userLogout(HttpServletRequest request) {
        request.getSession().getAttribute(USER_LOGIN_STATE);
        return 1;
    }


}




