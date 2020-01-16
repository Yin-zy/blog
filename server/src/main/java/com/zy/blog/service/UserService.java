package com.zy.blog.service;

import com.zy.blog.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 新增用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 查询用户信息列表
     * @return List<User>
     */
    List<User> findAllUserInfo();

    /**
     * 更新用户信息
     * @param user
     */
    void updateUserInfo(User user);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User queryUserInfoByName(String userName);
}
