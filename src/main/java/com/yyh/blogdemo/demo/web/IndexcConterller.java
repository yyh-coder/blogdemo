package com.yyh.blogdemo.demo.web;

import com.yyh.blogdemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexcConterller {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String toindex(){
        return "index";
    }

//    @RequestMapping("reg")
//    public String register(String userId,String username,String password){
//        try {
//            userService.reg(userId,username,password);
//            return "login";
//        }catch (RuntimeException e){
//            e.printStackTrace();
//            return "404";
//        }
//    }

//    @RequestMapping(value = "login",method = RequestMethod.GET)
//    public String toLogin(){
//        return "login";
//    }
//    @RequestMapping(value = "login",method = RequestMethod.POST)
//    public String doLogin(){
//        return "login";
//    }
}
