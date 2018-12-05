package com.yidiandian.controller;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
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

    @GetMapping("/hi")
    public String home(@RequestParam String name){
        return "hi:"+name+"how are you?"+port;
    }

    @PostMapping("/save-user")
    public UserInfo save(@RequestBody  UserInfo userInfo){
        UserInfo userInfo1 = userInfoService.save(userInfo);
        return userInfo1;
    }

}
