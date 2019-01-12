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
@Component
@EnableScheduling
public class BookTask {
    private long count =0 ;

    @Autowired
    private UserInfoService userInfoService;

    @Scheduled(fixedRate = 1000*60*60*30)
    public void taskA(){
        saveAndFlash();
        System.out.println("当前时间："+System.currentTimeMillis()+"\n执行次数："+count++);
    }


    public void saveAndFlash(){

        userInfoService.delete();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("张洁");
        userInfo.setNickName("xiaopangzi");
        userInfo.setPassword("12345678");
        userInfo.setSex("女");
        userInfo.setPhone("18101820186");
        userInfo.setAddress("江苏淮安");
        userInfo.setMail("18101820186@163.com");
        userInfo.setBirthday(LocalDateTime.of(1987,11,03,0,0,0));
        userInfo.setCreateTime(LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
        userInfo.setUpdateTime(LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
        userInfo.setIdNumber("J368368000");
        userInfo.setDeleteFlag(false);
        userInfoService.save(userInfo);

        UserInfo userInfoA = new UserInfo();
        userInfoA.setUserName("张杰");
        userInfoA.setNickName("zhangjie");
        userInfoA.setPassword("12345678");
        userInfoA.setSex("女");
        userInfoA.setPhone("18220181920");
        userInfoA.setMail("zhangjie@163.com");
        userInfoA.setAddress("沈丘");
        userInfoA.setBirthday(LocalDateTime.of(1995,9,20,0,0,0));
        userInfoA.setCreateTime(LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
        userInfoA.setUpdateTime(LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
        userInfoA.setIdNumber("z368368000");
        userInfoA.setDeleteFlag(false);
        userInfoService.save(userInfoA);

        UserInfo userInfoB = new UserInfo();
        userInfoB.setUserName("范雅轩");
        userInfoB.setNickName("fanyaxuan");
        userInfoB.setPassword("12345678");
        userInfoB.setSex("女");
        userInfoB.setPhone("18501820186");
        userInfoB.setAddress("黑龙江佳木斯");
        userInfoB.setMail("fanyaxuan@163.com");
        userInfoB.setBirthday(LocalDateTime.of(1997,11,03,0,0,0));
        userInfoB.setCreateTime(LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
        userInfoB.setUpdateTime(LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
        userInfoB.setIdNumber("fyx368368000");
        userInfoB.setDeleteFlag(false);
        userInfoService.save(userInfoB);

        UserInfo userInfoC = new UserInfo();
        userInfoC.setUserName("小胖子凹凸曼");
        userInfoC.setNickName("xiaopangzi");
        userInfoC.setPassword("xiaopangzi");
        userInfoC.setSex("女");
        userInfoC.setPhone("18101820186");
        userInfoC.setAddress("江苏淮安");
        userInfoC.setMail("xiaopangzi@163.com");
        userInfoC.setBirthday(LocalDateTime.of(1987,11,03,0,0,0));
        userInfoC.setCreateTime(LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
        userInfoC.setUpdateTime(LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
        userInfoC.setIdNumber("xpz368368000");
        userInfoC.setDeleteFlag(false);
        userInfoService.save(userInfoC);
    }
}
