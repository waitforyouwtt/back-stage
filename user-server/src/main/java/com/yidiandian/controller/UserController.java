package com.yidiandian.controller;

import com.yidiandian.config.RedisDao;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

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
    @Value("${appusername}")
    String appusername;
    @Value("${declaration.love}")
    String declarationLove;

    @GetMapping("/hi")
    public String home(@RequestParam String name){
        return "hi:"+name+"how are you?"+appusername+" : "+declarationLove;
    }


    @ApiOperation(notes = "保存用户信息",value = "保存用户信息")
    @PostMapping("/register-user")
    public UserInfo save(@RequestBody  UserInfo userInfo){
        UserInfo checkUser  = userInfoService.checkUser(userInfo);
        if(checkUser != null){
          return checkUser;
        }
        UserInfo result = userInfoService.save(userInfo);
        redisDao.setKey("name",userInfo.getUserName());
        redisDao.setKey("age",userInfo.getIdNumber());
        return result;
    }

}
