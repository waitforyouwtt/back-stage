package com.yidiandian.repository;

import com.yidiandian.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 一点点
 * @Date: 2018/12/5 22:50
 * @Version 1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
}
