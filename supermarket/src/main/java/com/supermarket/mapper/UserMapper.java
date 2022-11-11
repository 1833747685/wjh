package com.supermarket.mapper;

import com.supermarket.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User login(@Param("user") User user);
}
