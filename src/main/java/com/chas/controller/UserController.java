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
import javax.servlet.http.HttpSession;
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
            attr.addFlashAttribute("errorMsg","非法的访问请求！");
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
          attributes.addFlashAttribute("msg","请输入完整信息！");
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
            attr.addFlashAttribute("errorMsg","非法的访问请求！");
            return "redirect:/error";
        }
        return "userP";
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request, RedirectAttributes attr){
        Map map = RequestContextUtils.getInputFlashMap(request);
        if(map == null){
            attr.addFlashAttribute("errorMsg","非法的访问请求！");
            return "redirect:/error";
        }
        return "error";
    }

    @RequestMapping(value = "/updateusermg",method = RequestMethod.POST)
    public String updateUserMg(int userid, String email, String phone, int rightid, String curusername, RedirectAttributes attr){
        User user = userService.selectUserById(userid);

        if(email.equals("")){
            attr.addFlashAttribute("msg","更新失败！非法的邮箱！");
            List<User> list = userService.selectAllUser();
            List<Right> rightList = rightService.selectAllRight();
            attr.addFlashAttribute("list",list);
            attr.addFlashAttribute("rightList",rightList);
            attr.addFlashAttribute("user",userService.selectUserByName(curusername));
            return "redirect:/usermg";
        }

        if(phone.equals("") || !phone.matches("\\d*")){
            attr.addFlashAttribute("msg","更新失败！非法的手机号！");
            List<User> list = userService.selectAllUser();
            List<Right> rightList = rightService.selectAllRight();
            attr.addFlashAttribute("list",list);
            attr.addFlashAttribute("rightList",rightList);
            attr.addFlashAttribute("user",userService.selectUserByName(curusername));
            return "redirect:/usermg";
        }
        if(rightid > 2 || rightid < 0){
            attr.addFlashAttribute("msg","更新失败！错误的权限等级！");
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
            attr.addFlashAttribute("msg","更新成功！");
            List<Right> rightList = rightService.selectAllRight();
            List<User> list = userService.selectAllUser();
            attr.addFlashAttribute("list",list);
            attr.addFlashAttribute("rightList",rightList);
            attr.addFlashAttribute("user",userService.selectUserByName(curusername));
            return "redirect:/usermg";
        }
        else
        {
            attr.addFlashAttribute("msg","无信息更新！");
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
            attr.addFlashAttribute("msg","更新失败！不合法的用户名！");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }

        if(email.equals("")){
            attr.addFlashAttribute("msg","更新错误！错误的邮箱格式！");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }

        if(phone.equals("") || !phone.matches("\\d*")){
            attr.addFlashAttribute("msg","更新失败！错误的手机号码！");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }
        if(rightid > 2 || rightid < 0){
            attr.addFlashAttribute("msg","更新失败！错误的权限等级！");
            attr.addFlashAttribute("user",user);
            return "redirect:/profile";
        }
        User old = userService.selectUserByName(username);
        if(old != null && old.getId() != userid){
            attr.addFlashAttribute("msg","更新失败！重复用户名！");
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
            attr.addFlashAttribute("msg","更新成功！");
            return "redirect:/profile";
        }
        else
        {
            attr.addFlashAttribute("user",user);
            attr.addFlashAttribute("msg","无信息更新！");
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
            attr.addFlashAttribute("errorMsg","邮箱不能为空！");
            return "redirect:/error";
        }
        if(phone.equals("")){
            attr.addFlashAttribute("errorMsg","手机号不能为空！");
            return "redirect:/error";
        }

        User user = userService.selectUserByEmailAndPhone(email, phone);
        if(user == null){
            attr.addFlashAttribute("errorMsg","密码或手机号不正确！");
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
            attr.addFlashAttribute("errorMsg","非法的访问请求！");
            return "redirect:/error";
        }
        return "reset";
    }

    @RequestMapping("/resetPwd")
    public String resetPwd(int userid, String newPwd, String newPwdCheck, RedirectAttributes attr){
        if(newPwd.equals("") || newPwdCheck.equals("")){
            attr.addFlashAttribute("errorMsg","密码不能为空！");
            return "redirect:/error";
        }

        if(!newPwd.equals(newPwdCheck)){
            attr.addFlashAttribute("errorMsg","密码不匹配！");
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
            attr.addFlashAttribute("errorMsg","不合法的用户名！");
            return "redirect:/error";
        }

        if(newPwd.equals("") || newPwdCheck.equals("")){
            attr.addFlashAttribute("errorMsg","密码不能为空！");
            return "redirect:/error";
        }

        if(!newPwd.equals(newPwdCheck)){
            attr.addFlashAttribute("errorMsg","密码不匹配！");
            return "redirect:/error";
        }

        if(email.equals("")){
            attr.addFlashAttribute("errorMsg","非法的邮箱地址！");
            return "redirect:/error";
        }

        if(phone.equals("") || !phone.matches("\\d*")){
            attr.addFlashAttribute("errorMsg","非法的手机号格式！");
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

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }


}