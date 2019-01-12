package com.yidiandian;

import com.yidiandian.dto.UserInfoDto;
import com.yidiandian.entity.LoginLog;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.LoginLogService;
import com.yidiandian.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan(basePackages = {"com.yidiandian.entity"}, basePackageClasses = Jsr310JpaConverters.class)
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
		/*LoginLog log = new LoginLog();
		log.setNickname("admin");
		log.setLoginIp("default");
		log.setLastLoginIp("default");
		log.setLoginTime(LocalDateTime.now());
		log.setLastLoginTime(LocalDateTime.now());
		log.setLoginNum(1);
		logService.save(log);*/
	}

	@Test
	public void queyrLog(){
		/*LoginLog log = new LoginLog();
		log.setNickname("admin");
		LoginLog result = logService.findByLoginNickName("admin");
		System.out.println("result:"+result);*/
	}

	@Test
	public void query(){
		UserInfoDto  userInfoDto = new UserInfoDto();
		List<UserInfo> list = userInfoService.findAll(userInfoDto);
		System.out.println("得到的数据是:"+list);
	}

}
