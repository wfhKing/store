package com.nf147.ssm.dao;

import com.nf147.ssm.entity.User;
import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int deleteByName(String userName);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    User getByName(String userName);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

}