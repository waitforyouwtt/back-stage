package com.yidiandian.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: 一点点
 * @Date: 2018/12/5 22:32
 * @Version 1.0
 */
@Entity
@Data
@ToString
@ApiModel(value = "用户信息表")
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class})
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 2474565371967135971L;

    @ApiModelProperty(name = "自增Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(name = "用户姓名，且是中文")
    @Column(nullable = false,unique = true)
    @Pattern(regexp = "^[\u4E00-\u9FA5]+$",message = "用户名格式错误")
    @Size(max = 30)
    private String userName;

    @ApiModelProperty(name = "用户密码")
    @Column
    @Size(min =8,max = 20,message = "密码长度为8-20之间")
    private String password;
    @ApiModelProperty(name = "性别")
    @Column
    @Size(max = 4)
    private String sex;
    @ApiModelProperty(name = "用户密码")
    @Column
    @Pattern(regexp = "^[150[0-9]+]{11}", message = "手机号格式错误")
    @Size(max = 15)
    private String phone;
    /** 邮箱 */
    @Email(message = "邮箱格式错误")
    @Size(max = 30)
    private String mail;

    @ApiModelProperty(name = "身份证号码")
    @Column(unique = true)
    @Size(max = 20)
    private String idNumber;

    @ApiModelProperty(name = "用户昵称")
    @Pattern(regexp = "^[a-z0-9A-Z_-]{3,15}$",message = "昵称格式错误")
    @Size(max = 30)
    private String nickName;

    @ApiModelProperty(name = "用户生日")
    @DateTimeFormat(pattern  ="yyyy-MM-dd")
    @Column(columnDefinition="timestamp default current_timestamp comment '生日'")
    private LocalDateTime birthday;

    @ApiModelProperty(name = "用户地址")
    @Size(min=1,max=20,message = "内容应该在5-20之间")
    private String address;

    @ApiModelProperty(name="是否删除")
    @ColumnDefault(value = "true")
    private boolean deleteFlag;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition="timestamp default current_timestamp comment '创建时间'")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition="timestamp default current_timestamp comment '修改时间'")
    private LocalDateTime updateTime;

}
