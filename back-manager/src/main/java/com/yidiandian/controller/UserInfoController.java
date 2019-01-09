package com.yidiandian.controller;

import com.yidiandian.dto.UserInfoDto;
import com.yidiandian.entity.LoginLog;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.LoginLogService;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.utils.VerifyCodeUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 一点点
 * @Date: 2018/12/16 15:23
 * @Version 1.0
 */
@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    LoginLogService loginLogService;


    @GetMapping("/")
    public String login(){
        return "login";
    }
    @GetMapping("/index")
    public String index(){
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

    @ApiOperation(value = "用户登陆，校验用户名，密码，验证码等信息。")
    @RequestMapping(value="valid-login",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,String> validImage(HttpServletRequest request, HttpSession session, UserInfo userInfo){
        String code = request.getParameter("code");
        Object verCode = session.getAttribute("verCode");

        Map<String,String> result = new HashMap<>(16);

        if (null == verCode) {
            request.setAttribute("errmsg", "验证码已失效，请重新输入");
            result.put("rCode","1000");
            result.put("message","验证码已失效，请重新输入");
            return result;
        }
        String verCodeStr = verCode.toString();
        LocalDateTime localDateTime = (LocalDateTime)session.getAttribute("codeTime");
        long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        String nickName = userInfo.getNickname();
        UserInfo getUserInfo = userInfoService.login(userInfo);

        if(verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)){
            request.setAttribute("errmsg", "验证码错误");
            result.put("rCode","1001");
            result.put("message","验证码错误");
            return result;
        } else if((now-past)/1000/60 >5){
            request.setAttribute("errmsg", "验证码已过期，重新获取");
            result.put("rCode","1002");
            result.put("message","验证码已过期，重新获取");
            return result;
        } else if(getUserInfo == null){
            request.setAttribute("errmsg", "用户名或密码错误");
            result.put("rCode","1003");
            result.put("message","用户名或密码错误");
            return result;
        }else  {
            saveLoginLog(nickName,request);
            //验证成功，删除存储的验证码
            session.removeAttribute("verCode");
            result.put("rCode","200");
            result.put("message","登陆成功");
            return result;
        }
    }
    @ApiOperation(value = "用户成功登陆，进入首页桌面显示")
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }

    @ApiOperation(value = "用户退出登陆")
    @GetMapping("/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 干掉cookie和session
        HttpSession session = request.getSession();
        session.removeAttribute("user");

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if ("autoLogin".equals(c.getName())) {
                    //设置cookie存活时间为0
                    c.setMaxAge(0);
                    //将cookie响应到前台
                    response.addCookie(c);
                    break;
                }
            }
        }
        // 重定向到首页
        response.sendRedirect(request.getContextPath() + "/index.html");
    }

    private void saveLoginLog(String nickname,HttpServletRequest request){
        LoginLog log = new LoginLog();
        log.setNickname(nickname);
        log.setLoginTime(LocalDateTime.now());
        log.setLastLoginTime(LocalDateTime.now());
        log.setLoginIp(request.getRemoteAddr());
        log.setLastLoginIp(request.getRemoteAddr());
        LoginLog loginLog = loginLogService.findByLoginNickName(nickname);
        if(loginLog != null){
            log.setLoginNum(loginLog.getLoginNum()+1);
        }else{
            log.setLoginNum(1);
        }
        loginLogService.save(log);
    }

    @GetMapping("/findUserInfoList")
    public ModelAndView findUserInfos(Model model,UserInfoDto userInfoDto){
        ModelAndView modelAndView = new ModelAndView("userInfoList");
        return modelAndView;
    }

    @GetMapping("/findUserInfos")
    @ResponseBody
    public List<UserInfoDto> findUserInfos(UserInfoDto userInfoDto, HttpServletRequest request) {
        return userInfoService.findAll(userInfoDto);
    }

}
