package com.yidiandian;

import com.yidiandian.entity.GoodsInfo;
import com.yidiandian.service.GoodsInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServerApplicationTests {

	@Autowired
	GoodsInfoService goodsInfoService;

	@Test
	public void contextLoads() {

		GoodsInfo goodsInfo =	goodsInfoService.findByGoodId("12");
		System.out.println("得到的结果:"+goodsInfo);
	}

	@Test
	public void queryId() {

		String result  =	goodsInfoService.findGoods("1567");
		System.out.println("得到的结果:"+result);
	}

}
