package com.yidiandian;

import com.yidiandian.entity.LoginLog;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.LoginLogService;
import com.yidiandian.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServerApplicationTests {

	@Autowired
	LoginLogService logService;

	@Autowired
	private UserInfoService userInfoService;
	@Test
	public void addUserInfo(){

	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void saveLog(){
		LoginLog log = new LoginLog();
		log.setNickname("admin");
		log.setLoginIp("default");
		log.setLastLoginIp("default");
		log.setLoginTime(LocalDateTime.now());
		log.setLastLoginTime(LocalDateTime.now());
		log.setLoginNum(1);
		logService.save(log);
	}

	@Test
	public void queyrLog(){
		LoginLog log = new LoginLog();
		log.setNickname("admin");
		LoginLog result = logService.findByLoginNickName("admin");
		System.out.println("result:"+result);
	}

}
