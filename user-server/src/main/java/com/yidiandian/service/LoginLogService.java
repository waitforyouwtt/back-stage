package com.yidiandian.service;

import com.yidiandian.entity.LoginLog;

/**
 * @Author: 一点点
 * @Date: 2019/1/1 13:29
 * @Version 1.0
 */
public interface LoginLogService {

    /**
     * 保存登陆信息
     * @param loginLog
     * @return
     */
    LoginLog save(LoginLog loginLog);

    /**
     * 根据用户昵称查找用户
     * @param nickname
     * @return
     */
    LoginLog findByLoginNickName(String nickname);
}
