package com.yidiandian.task;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: 一点点
 * @Date: 2018/12/7 10:56
 * @Version 1.0
 */
/*@Component
@EnableScheduling
public class BookTask {
    private long count =0 ;

    @Autowired
    private UserInfoService userInfoService;

    @Scheduled(fixedRate = 1000*60*60*30)
    public void taskA(){
        System.out.println("当前时间："+System.currentTimeMillis()+"\n执行次数："+count++);
    }
}*/
