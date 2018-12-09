package com.yidiandian.service;

import org.springframework.stereotype.Component;

/**
 * @Author: 一点点
 * @Date: 2018/12/9 11:29
 * @Version 1.0
 */
@Component
public class HiHystrix implements EurekaClientFeign{
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi,"+name+"sorry，error";
    }
}
