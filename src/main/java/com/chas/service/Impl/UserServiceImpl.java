package com.chas.service.Impl;

import com.chas.dao.UserDao;
import com.chas.model.User;
import com.chas.service.UserService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.uwyn.jhighlight.fastutil.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by ShirUshI on 2017/5/8.
 */
@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;


    public HashMap selectUserWithTypeByName(String userName){
        return userDao.selectUserWithTypeByName(userName);
    }

    public String checkLogin(String userName, String password){
        User user = userDao.selectUserByName(userName);
        if(user == null)
            return "Invalid Username";
        else if (user.getPassword().equals(password))
            return "success";
        else
            return "Invalid Password";
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public User selectUserById(int id){
        User user = userDao.selectUserById(id);
        return user;
    }

    public User selectUserByName(String userName){
        return userDao.selectUserByName(userName);
    }

    public boolean userUpdateCheck(User user){
        User old = userDao.selectUserById(user.getId());
        if(old.getUsername().equals(user.getUsername()) && user.getEmail().equals(old.getEmail()) && user.getPhone().equals(old.getPhone())){
            return false;
        }
        else
            return true;
    }

}
