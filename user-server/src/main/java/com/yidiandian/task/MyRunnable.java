package com.yidiandian.task;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.utils.FrameSpringBeanUtil;
import com.yidiandian.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: 一点点
 * @Date: 2019/4/23 20:51
 * @Version 1.0
 */
/*@Component
@EnableScheduling
public class MyRunnable implements Runnable {

   *//* @Autowired
    private UserInfoService userInfoService;*//*

    //因为是多线程所以无法注入bean 对象，只能通过下面方法去获取bean 对象
    private JedisCluster jedisCluster = FrameSpringBeanUtil.getBean(JedisCluster.class);

    @Override
    public void run() {
        //加锁，调用工具类
        boolean lock = RedisUtil.tryGetDistributedLock( jedisCluster,MyRunnable.class.toString(),MyRunnable.class.toString(),3000 );
        //加锁成功则执行业务，不成功不执行业务
        if (lock){
            System.out.println("-----------执行业务代码-----------");
           // saveAndFlash();
            //业务执行完成解锁，如果在执行业务中或者解锁异常，宕机，锁会根据加锁时的key 过期时间自己消除
            RedisUtil.releaseDistributedLock( jedisCluster,MyRunnable.class.toString(),MyRunnable.class.toString() );
        }
    }*/
    //每1分钟执行一次
    /*@Scheduled(cron = "0 * * * * ?")
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
        userInfo.setBirthday( LocalDateTime.of(1987,11,03,0,0,0));
        userInfo.setCreateTime(LocalDateTime.of( LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth(),0,0,0));
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
    }*/
//}
