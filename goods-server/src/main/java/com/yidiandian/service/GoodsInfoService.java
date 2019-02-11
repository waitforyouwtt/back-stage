package com.yidiandian.service;

import com.yidiandian.entity.GoodsInfo;

/**
 * @Author: 一点点
 * @Date: 2019/1/29 21:58
 * @Version 1.0
 */
public interface GoodsInfoService {

   GoodsInfo findByGoodId(String goodId);

   String findGoods(String goodId);
}
