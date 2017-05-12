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
import java.util.List;

/**
 * Created by ShirUshI on 2017/5/8.
 */
@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;


    public HashMap selectUserWithTypeByName(String userName){
        HashMap map = userDao.selectUserWithTypeByName(userName);
        if(map == null)
            return null;
        else
            return map;
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
        User user = userDao.selectUserByName(userName);
        if(user != null)
            return user;
        else
            return null;
    }

    public boolean userUpdateCheck(User user){
        User old = userDao.selectUserById(user.getId());
        if(old.getUsername().equals(user.getUsername()) && user.getEmail().equals(old.getEmail()) && user.getPhone().equals(old.getPhone()) && user.getRight()==old.getRight()){
            return false;
        }
        else
            return true;
    }

    public User selectUserByEmailAndPhone(String email, String phone){
        HashMap map = new HashMap();
        map.put("email",email);
        map.put("phone",phone);
        return userDao.selectUserByEmailAndPhone(map);
    }

    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> selectAllUser(){
        return userDao.selectAllUser();
    }

    public void deleteUserById(int id){
        userDao.deleteUserById(id);
    }

}
