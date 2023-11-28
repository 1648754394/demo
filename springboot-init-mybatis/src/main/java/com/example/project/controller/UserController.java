package com.example.project.controller;

import com.example.project.common.Response;
import com.example.project.domain.User;
import com.example.project.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "1.0-用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "新增用户")
    @PostMapping("/insert")
    public Response insertUser(@RequestBody User user) {
      int result = userService.insertUser(user);
      return Response.success(result);
    }

    @Operation(summary = "查询用户")
    @PostMapping("/getUserList")
    public Response getUserList(@RequestBody User user) {
        List<User> result = userService.selectUserList(user);
        return Response.success(result);
    }

    @Operation(summary = "更新用户")
    @PostMapping("/updateUser")
    public Response updateUser(@RequestBody User user) {
        int result = userService.updateUser(user);
        return Response.success(result);
    }

}
