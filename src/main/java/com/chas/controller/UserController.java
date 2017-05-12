package com.chas.controller;

import com.chas.model.Right;
import com.chas.model.User;
import com.chas.service.RightService;
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
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ShirUshI on 2017/5/8.
 */
@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RightService rightService;

    @RequestMapping("/usermg")
    public String userMg(HttpServletRequest request, RedirectAttributes attr){
        Map map = RequestContextUtils.getInputFlashMap(request);
        if(map == null){
            attr.addFlashAttribute("errorMsg","Invalid Access.");
            return "redirect:/error";
        }
        return "userM";
    }

    @RequestMapping("/userList")
    public String userList(String username, String password, RedirectAttributes attr){
        List<User> list = userService.selectAllUser();
        User user = userService.selectUserByName(username);
        List<Right> rightList = rightService.selectAllRight();
        attr.addFlashAttribute("user",user);
        attr.addFlashAttribute("list",list);
        attr.addFlashAttribute("rightList",rightList);
        return "redirect:/usermg";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(String username, String password, RedirectAttributes attributes){
        if(username == "" || password == ""){
          attributes.addFlashAttribute("msg","Please enter complete information.");
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
    public String profile(HttpServletRequest request, RedirectAttributes attr){
        Map map = RequestContextUtils.getInputFlashMap(request);
        if(map == null){
            attr.addFlashAttribute("errorMsg","Invalid Access.");
            return "redirect:/error";
        }
        return "userP";
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request, RedirectAttributes attr){
        Map map = RequestContextUtils.getInputFlashMap(request);
        if(map == null){
            attr.addFlashAttribute("errorMsg","Invalid Access.");
            return "redirect:/error";
        }
        return "error";
    }

    @RequestMapping(value = "/updateusermg",method = RequestMethod.POST)
    public String updateUserMg(int userid, String email, String phone, int rightid, String curusername, RedirectAttributes attr){
        User user = userService.selectUserById(userid);

        if(email.equals("")){
            attr.addFlashAttribute("msg","Update failed! Invalid Email.");
            List<User> list = userService.selectAllUser();
            List<Right> rightList = rightService.selectAllRight();
            attr.addFlashAttribute("list",list);
            attr.addFlashAttribute("rightList",rightList);
            attr.addFlashAttribute("user",userService.selectUserByName(curusername));
            return "redirect:/usermg";
        }

        if(phone.equals("") || !phone.matches("\\d*")){
            attr.addFlashAttribute("msg","Update failed! Invalid Phone Number.");
            List<User> list = userService.selectAllUser();
            List<Right> rightList = rightService.selectAllRight();
            attr.addFlashAttribute("list",list);
            attr.addFlashAttribute("rightList",rightList);
            attr.addFlashAttribute("user",userService.selectUserByName(curusername));
            return "redirect:/usermg";
        }
        if(rightid > 2 || rightid < 0){
            attr.addFlashAttribute("msg","Update failed! Invalid Right.");
            List<User> list = userService.selectAllUser();
            List<Right> rightList = rightService.selectAllRight();
            attr.addFlashAttribute("list",list);
            attr.addFlashAttribute("rightList",rightList);
            attr.addFlashAttribute("user",userService.selectUserByName(curusername));
            return "redirect:/usermg";
        }

        user.setEmail(email);
        user.setPhone(phone);
        user.setRight(rightid);
        if(userService.userUpdateCheck(user)){
            userService.updateUser(user);
            attr.addFlashAttribute("msg","Change completed");
            List<Right> rightList = rightService.selectAllRight();
            List<User> list = userService.selectAllUser();
            attr.addFlashAttribute("list",list);
            attr.addFlashAttribute("rightList",rightList);
            attr.addFlashAttribute("user",userService.selectUserByName(curusername));
            return "redirect:/usermg";
        }
        else
        {
            attr.addFlashAttribute("msg","No information changed");
            List<User> list = userService.selectAllUser();
            List<Right> rightList = rightService.selectAllRight();
            attr.addFlashAttribute("list",list);
            attr.addFlashAttribute("rightList",rightList);
            attr.addFlashAttribute("user",userService.selectUserByName(curusername));
            return "redirect:/usermg";
        }

    }

    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    public String updateUser(int userid, String username, String email, String phone, int rightid, RedirectAttributes attr){
        User user = userService.selectUserById(userid);
        if(username.equals("") || !username.matches("\\w*")){
            attr.addFlashAttribute("msg","Update failed! Invalid User Name.");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }

        if(email.equals("")){
            attr.addFlashAttribute("msg","Update failed! Invalid Email.");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }

        if(phone.equals("") || !phone.matches("\\d*")){
            attr.addFlashAttribute("msg","Update failed! Invalid Phone Number.");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }
        if(rightid > 2 || rightid < 0){
            attr.addFlashAttribute("msg","Update failed! Invalid Right.");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }
        User old = userService.selectUserByName(username);
        if(old != null && old.getId() != userid){
            attr.addFlashAttribute("msg","Update failed! Duplicate User Name.");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRight(rightid);
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

    @RequestMapping("/forget")
    public String forget(){
        return "forget";
    }

    @RequestMapping("/findPwd")
    public String forgetPassword(String email, String phone, RedirectAttributes attr){
        if(email.equals("")){
            attr.addFlashAttribute("errorMsg","Email cannot be none.");
            return "redirect:/error";
        }
        if(phone.equals("")){
            attr.addFlashAttribute("errorMsg","Phone Number cannot be none.");
            return "redirect:/error";
        }

        User user = userService.selectUserByEmailAndPhone(email, phone);
        if(user == null){
            attr.addFlashAttribute("errorMsg","Email or Phone Number is incorrect.");
            return "redirect:/error";
        }
        else {
            attr.addFlashAttribute("user",user);
            return "redirect:/reset";
        }
    }

    @RequestMapping("/reset")
    public String reset(HttpServletRequest request, RedirectAttributes attr){
        Map map = RequestContextUtils.getInputFlashMap(request);
        if(map == null){
            attr.addFlashAttribute("errorMsg","Invalid Access.");
            return "redirect:/error";
        }
        return "reset";
    }

    @RequestMapping("/resetPwd")
    public String resetPwd(int userid, String newPwd, String newPwdCheck, RedirectAttributes attr){
        if(newPwd.equals("") || newPwdCheck.equals("")){
            attr.addFlashAttribute("errorMsg","Password cannot be none.");
            return "redirect:/error";
        }

        if(!newPwd.equals(newPwdCheck)){
            attr.addFlashAttribute("errorMsg","Password cannot match.");
            return "redirect:/error";
        }

        User user = userService.selectUserById(userid);
        user.setPassword(newPwd);
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("/signup")
    public String signPage(){
        return "signup";
    }

    @RequestMapping("/createUser")
    public String signUp(String username, String newPwd, String newPwdCheck, String email, String phone, int rightid, RedirectAttributes attr){
        if(username.equals("") || !username.matches("\\w*") || userService.selectUserByName(username) != null){
            attr.addFlashAttribute("errorMsg","Invalid User Name.");
            return "redirect:/error";
        }

        if(newPwd.equals("") || newPwdCheck.equals("")){
            attr.addFlashAttribute("errorMsg","Password cannot be none.");
            return "redirect:/error";
        }

        if(!newPwd.equals(newPwdCheck)){
            attr.addFlashAttribute("errorMsg","Password cannot match.");
            return "redirect:/error";
        }

        if(email.equals("")){
            attr.addFlashAttribute("errorMsg","Invalid Email.");
            return "redirect:/error";
        }

        if(phone.equals("") || !phone.matches("\\d*")){
            attr.addFlashAttribute("errorMsg","Invalid Phone Number.");
            return "redirect:/error";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(newPwd);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRight(rightid);
        userService.insertUser(user);
        return "redirect:/";
    }


    @RequestMapping("/deleteuser")
    public String deleteUser(int userid, String curusername, RedirectAttributes attr){
        userService.deleteUserById(userid);
        List<User> list = userService.selectAllUser();
        List<Right> rightList = rightService.selectAllRight();
        attr.addFlashAttribute("list",list);
        attr.addFlashAttribute("rightList",rightList);
        attr.addFlashAttribute("user",userService.selectUserByName(curusername));
        return "redirect:/usermg";
    }


}