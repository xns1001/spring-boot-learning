package me.xns.springdemo.dao;

import me.xns.springdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xns on 2017/7/13.
 */
@Mapper
public interface UserMapper {
    List<User> findUserByMoreThanAge(@Param("age")Integer age);
}
