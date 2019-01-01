package com.yidiandian.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: 一点点
 * @Date: 2019/1/1 13:19
 * @Version 1.0
 */
@Entity
@Data
@ToString
public class LoginLog implements Serializable {

    private static final long serialVersionUID = -765316840149792976L;
    @ApiModelProperty(name = "自增Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 登陆用户昵称
     */
    private String nickname;
    /**
     * 当天登陆次数
     */
    private Integer loginNum = 0;
    /**
     * 登陆ip
     */
    private String loginIp;
    /**
     * 上次登陆ip
     */
    private String lastLoginIp;
    /**
     * 当前登陆时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginTime;
    /**
     * 上次登陆时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

}
