package com.chas.dao;
import com.chas.model.User;

import java.util.HashMap;

/**
 * Created by ShirUshI on 2017/5/8.
 */
public interface UserDao {

//    void selectAllUser();

    /*
    * Get user by name
    * @param userName
    * @return
    *
    * */
    HashMap selectUserWithTypeByName(String userName);

    User selectUserByName(String userName);

}
