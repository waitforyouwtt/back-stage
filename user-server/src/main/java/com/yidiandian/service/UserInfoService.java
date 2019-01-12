package com.yidiandian.service;

import com.yidiandian.dto.UserInfoDto;
import com.yidiandian.entity.UserInfo;

import java.awt.print.Pageable;
import java.util.List;

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
    /**
     * 查询用户集合
     */
    List<UserInfo> findAll();

    List<UserInfo> findAll(UserInfoDto userInfoDto);

    void delete();


}
