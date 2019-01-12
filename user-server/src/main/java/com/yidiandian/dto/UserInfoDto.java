package com.yidiandian.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: 一点点
 * @Date: 2019/1/6 12:33
 * @Version 1.0
 */
@Data
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class})
public class UserInfoDto {


    private Long id;

    private String userName;

    private String password;

    private String idNumber;

    private String nickName;

    private String phone;

    @DateTimeFormat(pattern  ="yyyy-MM-dd")
    private LocalDateTime birthday;

    private String address;

    private String sex;

    private String mail;

    private String deleteFlag;

    @DateTimeFormat(pattern  ="yyyy-MM-dd")
    private LocalDateTime createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private String birthdayS;

    private String createTimeS;

    private String updateTimeS;

    private String createTimeStart;

    private String createTimeEnd;


}
