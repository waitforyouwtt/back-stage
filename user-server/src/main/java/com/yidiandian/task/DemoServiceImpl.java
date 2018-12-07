package com.yidiandian.task;

import org.springframework.stereotype.Service;

/**
 * @Author: 一点点
 * @Date: 2018/10/5 22:44
 * @Version 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public void server(String s) {
        System.out.println("quarz-------begin!");
    }
}
