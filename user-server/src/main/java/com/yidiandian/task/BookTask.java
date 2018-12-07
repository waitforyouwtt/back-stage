package com.yidiandian.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: 一点点
 * @Date: 2018/12/7 10:56
 * @Version 1.0
 */
@Component
@EnableScheduling
public class BookTask {
    private long count =0 ;
    @Scheduled(fixedRate = 1000)
    public void taskA(){
        System.out.println("当前时间："+System.currentTimeMillis()+"\n执行次数："+count++);
    }
}
