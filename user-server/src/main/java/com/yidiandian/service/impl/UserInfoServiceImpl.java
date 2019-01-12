package com.yidiandian.service.impl;

import com.yidiandian.dto.UserInfoDto;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.repository.UserInfoRepository;
import com.yidiandian.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/12/5 22:52
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserInfo save(UserInfo userInfo){
      UserInfo userInfo1 =  userInfoRepository.save(userInfo);
      return userInfo1;
    }

    /**
     * 用户登陆
     *
     * @param userInfo
     */
    @Override
    public UserInfo login(UserInfo userInfo) {
        UserInfo result = null;
        if(StringUtils.isNotBlank(userInfo.getUserName())){
            result = userInfoRepository.findByUserNameAndPassword(userInfo.getUserName(),userInfo.getPassword());
        }else{
            result = userInfoRepository.findByNickNameAndPassword(userInfo.getNickName(),userInfo.getPassword());
        }
        return result;
    }

    /**
     * 判断是否已注册
     *
     * @param userInfo
     */
    @Override
    public UserInfo checkUser(UserInfo userInfo) {
        return userInfoRepository.findByIdNumberAndUserName(userInfo.getIdNumber(),userInfo.getUserName());
    }

    /**
     * 查询用户集合
     *
     * @param
     */
    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public List<UserInfo> findAll(UserInfoDto userInfoDto) {

        String timeStart = userInfoDto.getCreateTimeStart();
        String timeEnd = userInfoDto.getCreateTimeEnd();

        String userName = userInfoDto.getUserName();

        List<UserInfo> resultList = null;
        Specification <UserInfoDto> querySpecifi = new Specification<UserInfoDto>() {
            @Override
            public Predicate toPredicate(Root<UserInfoDto> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(timeStart)) {
                    //大于或等于传入时间
                    predicates.add( cb.greaterThanOrEqualTo(root.get("createTime").as(String.class),timeStart.concat("00:00:00") ));
                }
                if (StringUtils.isNotBlank(timeEnd)) {
                    //小于或等于传入时间
                    predicates.add( cb.lessThanOrEqualTo(root.get("createTime").as(String.class), timeEnd.concat("23:59:59")));
                }
                if (StringUtils.isNotBlank(userName)) {
                    //模糊查找
                    predicates.add(cb.like(root.get("userName").as(String.class), "%" + userName + "%"));
                }
                // and到一起的话所有条件就是且关系，or就是或关系
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return this.userInfoRepository.findAll(querySpecifi);
    }

    @Override
    public void delete() {
        userInfoRepository.deleteAll();
    }
}
