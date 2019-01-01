package com.yidiandian.repository;

import com.yidiandian.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2019/1/1 13:28
 * @Version 1.0
 */
public interface LoginLogRepository extends JpaRepository<LoginLog,Long> {
    /**
     *
     * @param nickname
     * @return
     */
    LoginLog findFirstByNicknameOrderByLoginTimeDesc(String nickname);
}
