package com.zy.blog.controller;

import com.zy.blog.entity.User;
import com.zy.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "user api")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息列表", httpMethod = "GET")
    @GetMapping("/")
    public List<User> findAllUserInfo(){
        return userService.findAllUserInfo();
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除用户信息", httpMethod = "GET")
    public void deleteUser(@ModelAttribute Integer id){
        userService.deleteUserById(id);
    }

    @ApiOperation(value = "保存用户信息", httpMethod = "POST")
    @PostMapping("/save")
    public User saveUserInfo(@ModelAttribute User user){
        userService.saveUser(user);
        return user;
    }

    @ApiOperation(value = "更新用户信息", httpMethod = "POST")
    @PostMapping("/update")
    public User updateUserInfo(@ModelAttribute User user){
        return user;
    }
}
