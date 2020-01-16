package com.zy.blog.repository;

import com.zy.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 查询所有未删除的用户信息
     * @param deleted
     * @return
     */
    List<User> findByDeleted(Boolean deleted);

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    User queryByName(String username);
}
