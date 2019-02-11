package com.yidiandian.service.impl;

import com.yidiandian.entity.GoodsInfo;
import com.yidiandian.mapper.GoodsInfoMapper;
import com.yidiandian.service.GoodsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 一点点
 * @Date: 2019/1/29 21:59
 * @Version 1.0
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    GoodsInfoMapper mapper;

    @Override
    public GoodsInfo findByGoodId(String goodId) {
        GoodsInfo goodsInfo = null;
        try{
            goodsInfo = mapper.findByGoodId(goodId);
        }catch (Exception e){
            logger.info("查询用户信息错误{}",e.getMessage());
            goodsInfo = new GoodsInfo();
        }
        return goodsInfo;
    }

    @Override
    public String findGoods(String goodId) {
        String result = null;
        try{
            GoodsInfo goodsInfo = mapper.findByGoodId(goodId);
            result = goodsInfo.getGoodName();
        }catch (Exception e){
            logger.error("查询商品信息错误{}",e.toString());
            e.printStackTrace();
            result = "异常啦";
        }
        return result;
    }
}
