package com.yidiandian.controller;

import com.yidiandian.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 一点点
 * @Date: 2018/12/16 15:23
 * @Version 1.0
 */
@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;


    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/index")
    public String index2(){
        return "index";
    }

}
