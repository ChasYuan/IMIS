package com.chas.controller;

import com.chas.model.Category;
import com.chas.model.City;
import com.chas.model.Shop;
import com.chas.model.User;
import com.chas.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by ShirUshI on 2017/5/16.
 */
@Controller
public class AnalysisController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityService cityService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("/analysis")
    public String analysisIndex(HttpServletRequest request, RedirectAttributes attr){
        Map map = RequestContextUtils.getInputFlashMap(request);
        if(map == null){
            attr.addFlashAttribute("errorMsg","非法身份的访问！请登录后进行访问！.");
            return "redirect:/error";
        }
        return "analysis";
    }

    @RequestMapping("/showdata")
    public String indexData(String username, RedirectAttributes attr){
        User user = userService.selectUserByName(username);
        List<City> cityList = cityService.selectAllCity();
        List<Category> categoryList = categoryService.selectAllCategory();
        List<Shop> shopList = shopService.selectAllShop();
        return null;
    }

}
