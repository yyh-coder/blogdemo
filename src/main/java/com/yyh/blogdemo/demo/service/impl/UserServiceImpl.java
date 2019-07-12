package com.yyh.blogdemo.demo.service.impl;

import com.yyh.blogdemo.demo.dal.UserRepo;
import com.yyh.blogdemo.demo.dal.entity.User;
import com.yyh.blogdemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void register(String username, String password) {


            User user1=new User();
            user1.setUsername(username);
            user1.setPassword(password);
        userRepo.save(user1);



    }

    @Override
    public User login(String username, String password) {
        User user=userRepo.findByUsernameAndPassword(username,password);
        System.out.println(user.getUsername());
        if(user==null){
            throw  new RuntimeException("USER_NOT_FOUND");
        }
        return user;
    }

//    @Override
//    public User Register(String userId, String username, String passwod) {
//
//        User user=
//
//        return user;
//    }
}
