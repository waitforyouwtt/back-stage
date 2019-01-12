package com.yidiandian.task;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

    @Scheduled(fixedRate = 1000*60)
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
        userInfo.setBirthday(LocalDate.of(1987,11,03));
        userInfo.setIdNumber("J368368000");
        userInfo.setDeleteFlag(false);
        userInfoService.save(userInfo);

        UserInfo userInfoA = new UserInfo();
        userInfoA.setUserName("张杰");
        userInfoA.setNickName("zhangjie");
        userInfoA.setPassword("12345678");
        userInfoA.setSex("女");
        userInfoA.setPhone("18101820186");
        userInfoA.setAddress("沈丘");
        userInfoA.setBirthday(LocalDate.of(1995,9,20));
        userInfoA.setIdNumber("z368368000");
        userInfoA.setDeleteFlag(false);
        userInfoService.save(userInfoA);

        UserInfo userInfoB = new UserInfo();
        userInfoB.setUserName("范雅轩");
        userInfoB.setNickName("fanyaxuan");
        userInfoB.setPassword("12345678");
        userInfoB.setSex("女");
        userInfoB.setPhone("18101820186");
        userInfoB.setAddress("黑龙江佳木斯");
        userInfoB.setBirthday(LocalDate.of(1997,11,03));
        userInfoB.setIdNumber("fyx368368000");
        userInfoB.setDeleteFlag(false);
        userInfoService.save(userInfoB);
    }
}
