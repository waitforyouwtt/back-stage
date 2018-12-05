package com.yidiandian.service.impl;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.repository.UserInfoRepository;
import com.yidiandian.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 一点点
 * @Date: 2018/12/5 22:52
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserInfo save(UserInfo userInfo){
      UserInfo userInfo1 =  userInfoRepository.save(userInfo);
      return userInfo1;
    }
}
