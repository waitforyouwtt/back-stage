package com.yidiandian.service.impl;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.repository.UserInfoRepository;
import com.yidiandian.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
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

    /**
     * 用户登陆
     *
     * @param userInfo
     */
    @Override
    public UserInfo login(UserInfo userInfo) {
        UserInfo result = null;
        if(StringUtils.isNotBlank(userInfo.getUsername())){
            result = userInfoRepository.findByUsernameOrNicknameAndPassword(userInfo.getUsername(),userInfo.getPassword());
        }else{
            result = userInfoRepository.findByUsernameOrNicknameAndPassword(userInfo.getNickname(),userInfo.getPassword());
        }
        return result;
    }

    /**
     * 判断是否已注册
     *
     * @param userInfo
     */
    @Override
    public UserInfo checkUser(UserInfo userInfo) {
        return userInfoRepository.findByIdNumberAndUsername(userInfo.getIdNumber(),userInfo.getUsername());
    }
}
