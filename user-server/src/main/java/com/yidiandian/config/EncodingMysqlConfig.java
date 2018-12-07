package com.yidiandian.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @Author: 一点点
 * @Date: 2018/12/7 12:05
 * @Version 1.0
 */
public class EncodingMysqlConfig extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }

}
