package com.chas.dao;
import com.chas.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ShirUshI on 2017/5/8.
 */
public interface UserDao {

//    void selectAllUser();

    /*
    * Get user with right type by name.
    * @param userName
    * @return
    *
    * */
    HashMap selectUserWithTypeByName(String userName);

    /*
    * Get user by name.
    * @param userName
    * @return
    * */
    User selectUserByName(String userName);

    /*
    * Update user.
    * @param User
    * */
    void updateUser(User user);

    User selectUserById(int id);

    User selectUserByEmailAndPhone(Map map);

    int insertUser(User user);
}
