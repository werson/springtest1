package com.werson.springtest.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wersom on 2017/10/19 0019.
 */
public class LoginAction extends ActionSupport {
    public LoginAction(){
        System.out.println("init LoginAction");
    }
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String execute() throws Exception {
        if (getUsername().equals("admin") && getPassword().equals("123456")) {
            ActionContext.getContext().getSession().put("user", getUsername());
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
}
