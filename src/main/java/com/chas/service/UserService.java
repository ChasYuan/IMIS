package com.chas.service;
import com.chas.model.User;
import java.util.HashMap;

/**
 * Created by ShirUshI on 2017/5/8.
 */
public interface UserService {


    /*
   * Get user by name
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
    String checkLogin(String userName, String password);

    /*
    * Update user.
    * @param User
    * */
    void updateUser(User user);

    User selectUserByName(String userName);

    User selectUserById(int id);

    boolean userUpdateCheck(User user);
}
