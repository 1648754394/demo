package com.example.project.service;

import com.example.project.domain.User;
import com.example.project.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {

  @Autowired
  UserMapper userMapper;

  public int insertUser(User user) {
    return userMapper.insertUser(user);
  }

  public List<User> selectUserList(User user) {
    return userMapper.selectUserList(user);
  }

  public int updateUser(User user) {
    return userMapper.updateUser(user);
  }
}
