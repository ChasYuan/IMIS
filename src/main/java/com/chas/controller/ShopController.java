package com.chas.controller;

import com.chas.model.Comment;
import com.chas.model.Shop;
import com.chas.model.User;
import com.chas.service.CommentService;
import com.chas.service.KeywordService;
import com.chas.service.ShopService;
import com.chas.service.UserService;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Created by ShirUshI on 2017/5/19.
 */
@Controller
public class ShopController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private KeywordService keywordService;

    private User user;
    private Shop shop;

    private HashSet<String> wordSet;
    private HashSet<String> wordSet11;
    private HashSet<String> wordSet10;
    private HashSet<String> wordSet21;
    private HashSet<String> wordSet20;
    private HashSet<String> wordSet31;
    private HashSet<String> wordSet30;
    private HashSet<String> wordSet41;
    private HashSet<String> wordSet40;
    private HashSet<String> wordSet51;
    private HashSet<String> wordSet50;
    private HashSet<String> wordSet61;
    private HashSet<String> wordSet60;

    @RequestMapping("/shop")
    public String showShop(String username, int id, Model model){
        user = userService.selectUserByName(username);
        shop = shopService.selectShopById(id);
        List<Comment> commentList = commentService.selectCommentByShopId(id);
        int commentSize = commentList.size();

        if(wordSet == null) wordSet = new HashSet<String>(keywordService.selectAllWord());
        if(wordSet11 == null) wordSet11 = new HashSet<String>(keywordService.selectWordByAS(1,1));
        if(wordSet10 == null ) wordSet10 = new HashSet<String>(keywordService.selectWordByAS(1,-1));
        if(wordSet21 == null) wordSet21 = new HashSet<String>(keywordService.selectWordByAS(2,1));
        if(wordSet20 == null) wordSet20 = new HashSet<String>(keywordService.selectWordByAS(2,-1));
        if(wordSet31 == null) wordSet31 = new HashSet<String>(keywordService.selectWordByAS(3,1));
        if(wordSet30 == null) wordSet30 = new HashSet<String>(keywordService.selectWordByAS(3,-1));
        if(wordSet41 == null) wordSet41 = new HashSet<String>(keywordService.selectWordByAS(4,1));
        if(wordSet40 == null) wordSet40 = new HashSet<String>(keywordService.selectWordByAS(4,-1));
        if(wordSet51 == null) wordSet51 = new HashSet<String>(keywordService.selectWordByAS(5,1));
        if(wordSet50 == null) wordSet50 = new HashSet<String>(keywordService.selectWordByAS(5,-1));
        if(wordSet61 == null) wordSet61 = new HashSet<String>(keywordService.selectWordByAS(6,1));
        if(wordSet60 == null) wordSet60 = new HashSet<String>(keywordService.selectWordByAS(6,-1));

        Iterator<String> setIt = wordSet.iterator();
        while(setIt.hasNext())
            DicLibrary.insert(DicLibrary.DEFAULT, setIt.next());

        int showComment1 = 0;
        int showComment2 = 0;
        int showComment3 = 0;


        double shopScore1 = shop.getTaste();
        double shopScore2 = shop.getEnvir();
        double shopScore3 = shop.getService();
        model.addAttribute("shopScore1",shopScore1);
        model.addAttribute("shopScore2",shopScore2);
        model.addAttribute("shopScore3",shopScore3);


        double usrTaste = 0;
        double usrEnvir = 0;
        double usrService = 0;

        int showCommentStar1 = 0;
        int showCommentStar2 = 0;
        int showCommentStar3 = 0;
        int showCommentStar4 = 0;
        int showCommentStar5 = 0;


        double showSQ1 = 0;
        int SQ1 = 0;
        double showSQ2 = 0;
        int SQ2 = 0;
        double showSQ3 = 0;
        int SQ3 = 0;
        double showSQ4 = 0;
        int SQ4 = 0;
        double showSQ5 = 0;
        int SQ5 = 0;
        double showSQ6 = 0;
        int SQ6 = 0;

        Iterator<Comment> commentIt = commentList.iterator();
        while(commentIt.hasNext()){
            Comment comment = commentIt.next();

            if(comment.getRemark() == 50) {
                showCommentStar5 += 1;
                showComment1 += 1;


            }
            else if(comment.getRemark() == 40){
                showCommentStar4 += 1;
                showComment1 += 1;
            }
            else if(comment.getRemark() == 30) {
                showCommentStar3 += 1;
                showComment2 += 1;
            }
            else if(comment.getRemark() == 20){
                showCommentStar2 += 1;
                showComment3 += 1;
            }
            else {
                showCommentStar1 += 1;
                showComment3 += 1;
            }


            usrTaste += comment.getTaste();
            usrEnvir += comment.getEnvir();
            usrService += comment.getService();

            List<Term> parse = ToAnalysis.parse(comment.getDetail()).getTerms();
            for(Term term : parse){
                String name = term.getName();
                if(wordSet10.contains(name)) {
                    showSQ1 -= 1;
                    SQ1 += 1;
                }
                if(wordSet11.contains(name)) {
                    showSQ1 += 1;
                    SQ1 += 1;
                }
                if(wordSet20.contains(name)){
                    showSQ2 -= 1;
                    SQ2 += 1;
                }
                if(wordSet21.contains(name)) {
                    showSQ2 += 1;
                    SQ2 += 1;
                }
                if(wordSet30.contains(name)) {
                    showSQ3 -= 1;
                    SQ3 += 1;
                }
                if(wordSet31.contains(name)) {
                    showSQ3 += 1;
                    SQ3 += 1;
                }
                if(wordSet40.contains(name)) {
                    showSQ4 -= 1;
                    SQ4 += 1;
                }
                if(wordSet41.contains(name)) {
                    showSQ4 += 1;
                    SQ4 += 1;
                }
                if(wordSet50.contains(name)){
                    showSQ5 -= 1;
                    SQ5 += 1;
                }
                if(wordSet51.contains(name)) {
                    showSQ5 += 1;
                    SQ5 += 1;
                }
                if(wordSet60.contains(name)){
                    showSQ6 -= 1;
                    SQ6 += 1;
                }
                if(wordSet61.contains(name)) {
                    showSQ6 += 1;
                    SQ6 += 1;
                }


            }

        }

        model.addAttribute("showComment1",showComment1);
        model.addAttribute("showComment2",showComment2);
        model.addAttribute("showComment3",showComment3);


        usrEnvir = (int)(( usrEnvir / commentSize) * 10);
        usrService = (int)((usrService / commentSize) * 10);
        usrTaste = (int)((usrTaste / commentSize) * 10);
        model.addAttribute("usrEnvir",usrEnvir / 10);
        model.addAttribute("usrService",usrService / 10);
        model.addAttribute("usrTaste",usrTaste / 10);

        model.addAttribute("showCommentStar1",showCommentStar1);
        model.addAttribute("showCommentStar2",showCommentStar2);
        model.addAttribute("showCommentStar3",showCommentStar3);
        model.addAttribute("showCommentStar4",showCommentStar4);
        model.addAttribute("showCommentStar5",showCommentStar5);


        model.addAttribute("user",user);
        model.addAttribute("shop",shop);

        showSQ1 = (double)(int)(( showSQ1 / SQ1 ) * 100) / 100;
        showSQ2 = (double)(int)(( showSQ2 / SQ2 ) * 100) / 100;
        showSQ3 = (double)(int)(( showSQ3 / SQ3 ) * 100) / 100;
        showSQ4 = (double)(int)(( showSQ4 / SQ4 ) * 100) / 100;
        showSQ5 = (double)(int)(( showSQ5 / SQ5 ) * 100) / 100;
        showSQ6 = (double)(int)(( showSQ6 / SQ6 ) * 100) / 100;
//        int[] temp = new int[]{showSQ1,showSQ2,showSQ3,showSQ4,showSQ5,showSQ6};
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i < 6; i++){
//            if(max < Math.abs(temp[i]))
//                max = Math.abs(temp[i]);
//        }
//        for(int i = 0; i < 6; i++){
//            temp[i] = temp[i] + max;
//            temp[i] = (int)(((double) temp[i] / (2.4 * max)) * 100);
//        }

        model.addAttribute("showSQ1",showSQ1);
        model.addAttribute("showSQ2",showSQ2);
        model.addAttribute("showSQ3",showSQ3);
        model.addAttribute("showSQ4",showSQ4);
        model.addAttribute("showSQ5",showSQ5);
        model.addAttribute("showSQ6",showSQ6);
        return "shopdata";
    }

}
