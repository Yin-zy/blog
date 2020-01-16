package com.zy.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "blog_user")
@Data
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String name;

    @Column(name = "user_password", nullable = false, unique = true)
    private String password;

    @Column(name = "user_age")
    private String age;

    @Column(name = "user_address")
    private String address;

    @Column(name = "create_date", columnDefinition = "datetime")
    private Date createDate = new Date();

    @Column(name = "update_date", columnDefinition = "datetime")
    private Date updateDate;

    @Column(name = "deleted")
    private Boolean deleted = false;
}
