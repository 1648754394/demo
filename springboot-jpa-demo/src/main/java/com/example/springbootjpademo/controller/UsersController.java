package com.example.springbootjpademo.controller;

import com.example.springbootjpademo.dao.UsersRepository;
import com.example.springbootjpademo.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/select")
    private List<Users> select() {
        return usersRepository.findAll();
    }

    @GetMapping("/selectByName")
    private List<Users> selectByName() {
        return usersRepository.findByUserName("cc");
    }

    @RequestMapping("/add")
    public void addUser()
    {
        Users user=new Users();
        user.setUserName("cc");
        usersRepository.save(user);
    }
}
