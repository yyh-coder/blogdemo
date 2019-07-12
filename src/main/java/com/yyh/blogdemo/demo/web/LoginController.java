package com.yyh.blogdemo.demo.web;

import com.yyh.blogdemo.demo.common.AppConstants;
import com.yyh.blogdemo.demo.dal.entity.User;
import com.yyh.blogdemo.demo.service.UserService;
import com.yyh.blogdemo.demo.web.from.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.swing.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String daLogin(LoginForm form, ModelMap modelMap, HttpSession session){

        try{
            User user=userService.login(form.getUsername(),form.getPassword());
            session.setAttribute(AppConstants.USER_INFO_SK,user);
        }catch (RuntimeException e){
            e.printStackTrace();
            if(e.getMessage().equals("USER_NOT_FOUND")){
                modelMap.put("msg","用户不存在或密码错误！");
                return "login";
            }
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("msg","系统异常。。");
            return "login";
        }


        return "index";
    }
}
