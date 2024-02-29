package com.example.springbootjpademo.dao;


import com.example.springbootjpademo.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsersRepository extends JpaRepository<Users,Integer> {
    List<Users> findByUserName(String userName);
}

