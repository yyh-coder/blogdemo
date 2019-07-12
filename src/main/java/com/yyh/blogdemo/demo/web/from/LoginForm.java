package com.yyh.blogdemo.demo.web.from;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginForm {

    private String username;

    private String password;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
