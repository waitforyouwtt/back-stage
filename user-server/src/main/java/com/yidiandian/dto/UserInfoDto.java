package com.yidiandian.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @Author: 一点点
 * @Date: 2019/1/6 12:33
 * @Version 1.0
 */
@Data
public class UserInfoDto {


    private Long id;

    private String username;

    private String password;

    private String idNumber;

    private String nickname;

    @DateTimeFormat(pattern  ="yyyy-MM-dd")
    private LocalDate birthday;

    private String address;

    private boolean deleteFlag;

    @DateTimeFormat(pattern  ="yyyy-MM-dd")
    private LocalDate createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate updateTime;

    private String createTimeStart;

    private String createTimeEnd;


}
