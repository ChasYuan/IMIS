package com.chas.controller;

import com.chas.model.User;
import com.chas.service.UserService;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/searchUser")
    public String searchUser(String username){
        User user = userService.selectUserByName(username);
        if(user != null)
            return "Invalid Username";
        else
            return "success";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(String username, String password, RedirectAttributes attributes){
        if(username == "" || password == ""){
          attributes.addFlashAttribute("errorMsg","Please enter complete information.");
            return "redirect:/error";
        }
        String result = userService.checkLogin(username, password);
        if(result.equals("success"))
        {
            User user = userService.selectUserByName(username);
            attributes.addFlashAttribute("user",user);
            attributes.addFlashAttribute("msg","Welcome to DCAA SYSTEM");
            return "redirect:/profile";
        }
        else{
            attributes.addFlashAttribute("errorMsg",result + ".");
            return "redirect:/error";
        }
    }

    @RequestMapping("/profile")
    public String profile(){
        return "userP";
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }

    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    public String updateUser(int userid, String username, String email, String phone, RedirectAttributes attr){
        User user = userService.selectUserById(userid);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        if(userService.userUpdateCheck(user)){
            userService.updateUser(user);
            attr.addFlashAttribute("user",user);
            attr.addFlashAttribute("msg","Change completed");
            return "redirect:/profile";
        }
        else
        {
            attr.addFlashAttribute("user",user);
            attr.addFlashAttribute("msg","No information changed");
            return "redirect:/profile";
        }

    }
}