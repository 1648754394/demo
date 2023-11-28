package com.example.project.mapper;

import com.example.project.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
  int insertUser(User user);

  List<User> selectUserList(User user);

  int updateUser(User user);
}
