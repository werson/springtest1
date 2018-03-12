package com.werson.springtest.action;

import com.opensymphony.xwork2.ActionSupport;
import com.werson.springtest.dao.UserDao;
import com.werson.springtest.model.User;

/**
 * Created by wersom on 2017/10/20 0020.
 */
public class RegisterAction extends ActionSupport {

    public RegisterAction(){
        System.out.println("init RegisterAction");
    }

    private UserDao userDao;
    private String username;
    private String password;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

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

        String userName = getUsername();
        String pwd = getPassword();
        System.out.println(userName+"::::"+pwd);
        User newUser = new User();
        newUser.setName(userName);
        newUser.setPassWord(pwd);

        userDao.addNewUser(newUser);
        return SUCCESS;
    }

}
