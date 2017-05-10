package com.chas.controller;

import com.chas.model.User;
import com.chas.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by ShirUshI on 2017/5/8.
 */
@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/usermg")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("userM");
        HashMap user = userService.selectUserWithTypeByName("chas");
       mav.addObject("user",user);
        return mav;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(String username, String password, Model model){
        if(username == "" || password == ""){
            model.addAttribute("errorMsg","Please enter complete information.");
            return "error";
        }
        User user = userService.checkLogin(username,password);
        if(user != null)
        {
            model.addAttribute("user",user);
            return "userP";
        }
        else{
            model.addAttribute("errorMsg","Password is incorrect.");
            return "error";
        }
    }

}