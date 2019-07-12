package com.yyh.blogdemo.demo.dal;

import com.yyh.blogdemo.demo.dal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsernameAndPassword(String username,String password);

//    User fingByUserId(String userId);
}
