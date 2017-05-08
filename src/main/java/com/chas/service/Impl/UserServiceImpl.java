package com.chas.service.Impl;

import com.chas.dao.UserDao;
import com.chas.model.User;
import com.chas.service.UserService;
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


    public HashMap selectUserByName(String userName){
        return userDao.selectUserByName(userName);
    }


}
