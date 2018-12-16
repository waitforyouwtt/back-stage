package com.yidiandian.service;

import com.yidiandian.entity.UserInfo;

/**
 * @Author: 一点点
 * @Date: 2018/12/5 22:47
 * @Version 1.0
 */
public interface UserInfoService {
    /**
     * 保存用户
     * @param userInfo
     * @return
     */
     UserInfo save(UserInfo userInfo);
    /**
     * 用户登陆
     */
     UserInfo login(UserInfo userInfo);
    /**
     * 判断是否已注册
     */
     UserInfo checkUser(UserInfo userInfo);

}
