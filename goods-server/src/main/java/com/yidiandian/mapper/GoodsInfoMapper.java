package com.yidiandian.mapper;

import com.yidiandian.entity.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 一点点
 * @Date: 2019/1/29 22:00
 * @Version 1.0
 */
public interface GoodsInfoMapper extends JpaRepository<GoodsInfo,String> {

    GoodsInfo findByGoodId(String goodId);
}
