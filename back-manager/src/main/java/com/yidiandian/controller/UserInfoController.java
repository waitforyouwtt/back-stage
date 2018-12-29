package com.yidiandian.controller;

import com.yidiandian.service.UserInfoService;
import com.yidiandian.utils.VerifyCodeUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

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
        return "login";
    }
    @PostMapping("/index")
    public String index2(){
        return "index";
    }
    @ApiOperation(value = "生成验证码，返回给前端")
    @RequestMapping(value="/getImage",method= RequestMethod.GET)
    public void authImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 存入会话session
        HttpSession session = request.getSession(true);
        // 删除以前的
        session.removeAttribute("verCode");
        session.removeAttribute("codeTime");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        session.setAttribute("codeTime", LocalDateTime.now());
        // 生成图片
        int w = 100, h = 30;
        OutputStream out = response.getOutputStream();
        VerifyCodeUtils.outputImage(w, h, out, verifyCode);
    }

}
