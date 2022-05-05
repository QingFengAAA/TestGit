package com.tedu.dataaccess.mapper;


import com.tedu.dataaccess.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
