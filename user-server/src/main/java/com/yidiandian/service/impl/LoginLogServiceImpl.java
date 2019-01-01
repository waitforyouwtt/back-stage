package com.yidiandian.service.impl;

import com.yidiandian.entity.LoginLog;
import com.yidiandian.repository.LoginLogRepository;
import com.yidiandian.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 一点点
 * @Date: 2019/1/1 13:29
 * @Version 1.0
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogRepository logRepository;

    @Override
    public LoginLog save(LoginLog loginLog){
        LoginLog log = logRepository.save(loginLog);
        return log;
    }

    /**
     * 根据用户昵称查找用户
     * @param nickname
     * @return
     */
    @Override
    public LoginLog findByLoginNickName(String nickname) {
        return  logRepository.findFirstByNicknameOrderByLoginTimeDesc(nickname);
    }
}
