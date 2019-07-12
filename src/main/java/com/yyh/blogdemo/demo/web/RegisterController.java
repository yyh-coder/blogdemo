package com.yyh.blogdemo.demo.web;

import com.yyh.blogdemo.demo.dal.entity.User;
import com.yyh.blogdemo.demo.service.UserService;
import com.yyh.blogdemo.demo.web.from.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String doRegister(RegisterForm form, ModelMap modelMap, HttpSession session){

        try{


            System.out.println(form.getUsername());
            System.out.println(form.getPassword());

            userService.register(form.getUsername(),form.getPassword());

        }catch (RuntimeException e){
            e.printStackTrace();
            if(e.getMessage().equals("USER_NOT_FOUND")){
                modelMap.put("msg","用户不存在或者密码不匹配");
                return "register";}
        }catch (Exception e){
            e.printStackTrace();
        }

        return "index";
    }

    public Map getJs(){
        Map map=new HashMap();
        StringBuffer pagingJsp=new StringBuffer();
        pagingJsp.append("<script type='text/javascript'>");
        pagingJsp.append("");
        pagingJsp.append("</script>");
        map.put("jsp",pagingJsp.toString());
        return map;
    }
}
