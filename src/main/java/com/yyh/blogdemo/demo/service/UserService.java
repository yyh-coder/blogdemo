package com.yyh.blogdemo.demo.service;

import com.yyh.blogdemo.demo.dal.entity.User;

public interface UserService {

    void register(String username,String password);

    User login(String username,String password);

//    User Register(String userId,String username,String passwod);
}
