package com.chas.test;

import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/19.
 */
public class AnsjTest {
    public static void main(String[] args){
        String str = "这家店实在是小了点，有点乱乱的而且桌椅板凳都太低了，服务也实在是差，上菜" +
                "的速度太慢。但是我喜欢他们的干锅牛蛙，特别是里面的笋尖和豆干丝太好吃了，是我每次去滴水洞的唯一理由。酸豆角炒腊肉也不错很下饭的，孜然排骨也可以量很多。";
        DicLibrary.insert(DicLibrary.DEFAULT, "乱乱的");
        List<Term> list = ToAnalysis.parse(str).getTerms();
        for(Term term : list){
            System.out.println(term.getName());
        }
        System.out.print(ToAnalysis.parse(str));
    }
}
