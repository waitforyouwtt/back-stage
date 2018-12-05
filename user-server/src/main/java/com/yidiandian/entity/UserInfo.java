package com.yidiandian.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Author: 一点点
 * @Date: 2018/12/5 22:32
 * @Version 1.0
 */
@Entity
@Data
@ToString
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 2474565371967135971L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    @Pattern(regexp = "^[\u4E00-\u9FA5]+$",message = "用户名格式错误")
    private String username;
    @Column
    @Size(min =8,max = 20,message = "密码长度为8-20之间")
    private String password;
    @Column(unique = true)
    private String idNumber;
    @Pattern(regexp = "^[a-z0-9A-Z_-]{3,15}$",message = "昵称格式错误")
    private String nickname;

    @DateTimeFormat(pattern  ="yyyy-MM-dd")
    private LocalDate birthday;
    @Size(min=1,max=20,message = "内容应该在5-20之间")
    private String address;
    @ColumnDefault(value = "true")
    private boolean deleteFlag;
    @ApiModelProperty(value = "创建时间")
    private LocalDate createTime;
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate updateTime;
}
