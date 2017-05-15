package com.chas.controller;

import com.chas.model.Aspect;
import com.chas.model.Keyword;
import com.chas.model.User;
import com.chas.service.AspectService;
import com.chas.service.KeywordService;
import com.chas.service.UserService;
import org.apache.http.HttpRequest;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ShirUshI on 2017/5/13.
 */
@Controller
public class KeywordController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private KeywordService keywordService;

    @Autowired
    private AspectService aspectService;

    @RequestMapping("/keyword")
    public String allKeyword(HttpServletRequest request, RedirectAttributes attr){
        Map map = RequestContextUtils.getInputFlashMap(request);
        if(map == null){
            attr.addFlashAttribute("errorMsg","Invalid Access.");
            return "redirect:/error";
        }
        return "keyword";
    }

    @RequestMapping("/listAllKeyword")
    public String listAllKeyword(String username, RedirectAttributes attr){
        User user = userService.selectUserByName(username);
        List<HashMap> keywordList = keywordService.selectAllKeywordWithDesc();
        List<Aspect> aspectList = aspectService.selectAllAspect();
        attr.addFlashAttribute("aspectList",aspectList);
        attr.addFlashAttribute("user",user);
        attr.addFlashAttribute("searchword","");
        attr.addFlashAttribute("keywordList",keywordList);
        return "redirect:/keyword";
    }

    @RequestMapping("/updatekeyword")
    public String updateKeyword(int id, int score,String curusername, RedirectAttributes attr){

        if(score == 1 || score == -1) {

            Keyword keyword = keywordService.selectKeywordById(id);

            if(keyword.getScore() == score){
                User user = userService.selectUserByName(curusername);
                List<HashMap> keywordList = keywordService.selectAllKeywordWithDesc();
                List<Aspect> aspectList = aspectService.selectAllAspect();
                attr.addFlashAttribute("aspectList",aspectList);
                attr.addFlashAttribute("msg", "无信息更新！");
                attr.addFlashAttribute("user", user);
                attr.addFlashAttribute("searchword","");
                attr.addFlashAttribute("keywordList", keywordList);
                return "redirect:/keyword";
            }
            else {
                keyword.setScore(score);
                keywordService.updateKeyword(keyword);
                User user = userService.selectUserByName(curusername);
                List<HashMap> keywordList = keywordService.selectAllKeywordWithDesc();
                List<Aspect> aspectList = aspectService.selectAllAspect();
                attr.addFlashAttribute("aspectList",aspectList);
                attr.addFlashAttribute("searchword","");
                attr.addFlashAttribute("msg", "更新成功！");
                attr.addFlashAttribute("user", user);
                attr.addFlashAttribute("keywordList", keywordList);
                return "redirect:/keyword";
            }
        }
        else{
            User user = userService.selectUserByName(curusername);
            List<HashMap> keywordList = keywordService.selectAllKeywordWithDesc();
            List<Aspect> aspectList = aspectService.selectAllAspect();
            attr.addFlashAttribute("aspectList",aspectList);
            attr.addFlashAttribute("searchword","");
            attr.addFlashAttribute("msg","更新失败！非法的程度信息。");
            attr.addFlashAttribute("user",user);
            attr.addFlashAttribute("keywordList",keywordList);
            return "redirect:/keyword";
        }

    }

    @RequestMapping("deletekeyword")
    public String deleteKeyword(int id, String curusername, RedirectAttributes attr){
        keywordService.deleteKeywordById(id);
        User user = userService.selectUserByName(curusername);
        List<HashMap> keywordList = keywordService.selectAllKeywordWithDesc();
        List<Aspect> aspectList = aspectService.selectAllAspect();
        attr.addFlashAttribute("aspectList",aspectList);
        attr.addFlashAttribute("msg","删除关键词成功！");
        attr.addFlashAttribute("user",user);
        attr.addFlashAttribute("searchword","");
        attr.addFlashAttribute("keywordList",keywordList);
        return "redirect:/keyword";
    }

    @RequestMapping("/createkeyword")
    public String createKeyword(String word, int aspectId, int score, String curusername, RedirectAttributes attr){

        User user = userService.selectUserByName(curusername);
        List<Aspect> aspectList = aspectService.selectAllAspect();
        if(word.equals("") || !word.matches("[\\u4e00-\\u9fa5]+")){
            List<HashMap> keywordList = keywordService.selectAllKeywordWithDesc();
            attr.addFlashAttribute("aspectList",aspectList);
            attr.addFlashAttribute("msg","添加失败！非法关键词。");
            attr.addFlashAttribute("user",user);
            attr.addFlashAttribute("searchword","");
            attr.addFlashAttribute("keywordList",keywordList);
            return "redirect:/keyword";
        }

        if(score == 1 || score == -1){
            Keyword keyword = new Keyword();
            keyword.setWord(word);
            keyword.setAspectId(aspectId);
            keyword.setScore(score);
            keywordService.insertKeyword(keyword);
            attr.addFlashAttribute("msg","添加成功！");
            List<HashMap> keywordList = keywordService.selectAllKeywordWithDesc();
            attr.addFlashAttribute("user",user);
            attr.addFlashAttribute("searchword","");
            attr.addFlashAttribute("keywordList",keywordList);
            attr.addFlashAttribute("aspectList",aspectList);
            return "redirect:/keyword";
        }
        else{
            List<HashMap> keywordList = keywordService.selectAllKeywordWithDesc();
            attr.addFlashAttribute("aspectList",aspectList);
            attr.addFlashAttribute("msg","添加失败！非法的程度信息。");
            attr.addFlashAttribute("user",user);
            attr.addFlashAttribute("searchword","");
            attr.addFlashAttribute("keywordList",keywordList);
            return "redirect:/keyword";
        }


    }

    @RequestMapping("/searchkeyword")
    public String searchKeyword(String curusername, String keyword, RedirectAttributes attr){
        List<HashMap> keywordList = keywordService.selectKeywordByKeyword(keyword);
        User user = userService.selectUserByName(curusername);
        List<Aspect> aspectList = aspectService.selectAllAspect();
        attr.addFlashAttribute("aspectList",aspectList);
        attr.addFlashAttribute("user",user);
        attr.addFlashAttribute("searchword",keyword);
        attr.addFlashAttribute("keywordList",keywordList);
        return "redirect:/keyword";
    }



}
