package com.yidiandian.repository;

import com.yidiandian.dto.UserInfoDto;
import com.yidiandian.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
    UserInfo findByUserNameAndPassword(String userName ,String password);

    /**
     * 根据用户名/昵称 和密码进行登陆
     * @param nickName
     * @param password
     * @return
     */
    UserInfo findByNickNameAndPassword(String nickName,String password);
    /**
     * 根据身份证号码和用户名判断用户是否已注册
     */
    UserInfo findByIdNumberAndUserName(String idNumber,String userName);

    List<UserInfo> findAllByUserNameAndNickNameAndAddress(String userName,String nickName,String address);

    List<UserInfo> findAll(Specification<UserInfoDto> params);

}
