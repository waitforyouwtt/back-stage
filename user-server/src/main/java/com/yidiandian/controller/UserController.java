package com.yidiandian.controller;

import com.yidiandian.config.RedisDao;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 一点点
 * @Date: 2018/12/4 23:11
 * @Version 1.0
 */
@RestController
public class UserController {

    @Value("${server.port}")
    String port;

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RedisDao redisDao;

    @GetMapping("/hi")
    public String home(@RequestParam String name){
        return "hi:"+name+"how are you?"+port;
    }


    @ApiOperation(notes = "保存用户信息",value = "保存用户信息")
    @PostMapping("/register-user")
    public UserInfo save(@RequestBody  UserInfo userInfo){
        UserInfo checkUser  = userInfoService.checkUser(userInfo);
        if(checkUser != null){
          return checkUser;
        }
        UserInfo result = userInfoService.save(userInfo);
        redisDao.setKey("name",userInfo.getUsername());
        redisDao.setKey("age",userInfo.getIdNumber());
        return result;
    }

    @ApiOperation(value = "用户登陆",notes = "用户登陆")
    @GetMapping("/login")
    public UserInfo login(@RequestBody UserInfo userInfo){
        UserInfo result = userInfoService.login(userInfo);
        return null;
    }

}
