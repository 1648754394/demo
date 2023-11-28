package com.example.project.service;

import com.example.project.constant.Constant;
import com.example.project.domain.User;
import com.example.project.mapper.UserMapper;
import com.example.project.mq.ActiveMQSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {

  @Autowired
  UserMapper userMapper;

  @Autowired
  private ActiveMQSender activeMQSender;

  public int insertUser(User user) {
    activeMQSender.publishTopic(Constant.USER_INSERT_LOG, user);
    return userMapper.insertUser(user);
  }

  public List<User> selectUserList(User user) {
    return userMapper.selectUserList(user);
  }

  public int updateUser(User user) {
    activeMQSender.publishQueue(Constant.USER_UPDATE_LOG, user);
    return userMapper.updateUser(user);
  }
}
