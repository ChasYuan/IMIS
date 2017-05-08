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
    HashMap selectUserByName(String userName);
}
