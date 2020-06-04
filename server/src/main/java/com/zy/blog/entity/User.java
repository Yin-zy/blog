package com.zy.blog.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "blog_user")
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
    private Integer age;

    @Column(name = "user_address")
    private String address;

    @Column(name = "create_date", columnDefinition = "datetime")
    private Date createDate = new Date();

    @Column(name = "update_date", columnDefinition = "datetime")
    private Date updateDate;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @Column(name = "salt")
    private Integer salt;

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public User() {
        this.salt = new Random ().nextInt(99999999);
    }
}
