package com.zy.blog.service.impl;

import com.zy.blog.entity.User;
import com.zy.blog.repository.UserRepository;
import com.zy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        user.setUpdateDate(new Date());
        userRepository.save(user);
    }

    /**
     * 查询用户信息列表
     *
     * @return List<User>
     */
    @Override
    public List<User> findAllUserInfo() {
        return userRepository.findByDeleted(false);
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @Override
    public void updateUserInfo(User user) {
        user.setUpdateDate(new Date());
        userRepository.save(user);
    }

    /**
     * 删除用户信息
     *
     * @param id
     */
    @Override
    public void deleteUserById(Integer id) {
        User user = userRepository.getOne(id);
        user.setDeleted(true);
        userRepository.save(user);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public User queryUserInfoByName(String userName) {
        return userRepository.queryByName(userName);
    }
}
