package com.yidiandian.repository;

import com.yidiandian.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 一点点
 * @Date: 2018/12/5 22:50
 * @Version 1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
    /**
     * 根据用户名/昵称 和密码进行登陆
     * @return
     */
    UserInfo findByUsernameAndPassword(String username ,String password);

    /**
     * 根据用户名/昵称 和密码进行登陆
     * @param nickname
     * @param password
     * @return
     */
    UserInfo findByNicknameAndPassword(String nickname,String password);
    /**
     * 根据身份证号码和用户名判断用户是否已注册
     */
    UserInfo findByIdNumberAndUsername(String idNumber,String username);
}
