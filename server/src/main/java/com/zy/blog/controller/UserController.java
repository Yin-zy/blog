package com.zy.blog.controller;

import com.zy.blog.entity.User;
import com.zy.blog.service.UserService;
import com.zy.blog.util.MD5Utils;
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

    @PostMapping("/delete")
    public void deleteUser(@ModelAttribute Integer id){
        userService.deleteUserById(id);
    }

    @PostMapping("/update")
    public User updateUserInfo(@ModelAttribute User user){
        return user;
    }

    @PostMapping("/save")
    @ResponseBody
    public User saveUserInfo(@RequestBody User user){
        user.setPassword(new MD5Utils().getSaltMD5(user.getPassword(),user.getSalt()));
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/")
    @ApiOperation(value = "获取用户信息列表", httpMethod = "GET")
    public List<User> findAllUserInfo(){
        return userService.findAllUserInfo();
    }

    public User updatePasswordByName(@ModelAttribute String username, @ModelAttribute String password){
        User user = userService.queryUserInfoByName(username);
        user.setPassword(password);
        userService.saveUser(user);
        return user;
    }

    @PostMapping("/loginVerify")
    public String loginVerify(@ModelAttribute String username, @ModelAttribute String password){
        User user = userService.queryUserInfoByName(username);
        password = new MD5Utils().getSaltMD5(password,user.getSalt());
        if(password.equals(user.getPassword())){
            return "登录成功";
        }else {
            return "用户名与密码不匹配";
        }
    }
}
