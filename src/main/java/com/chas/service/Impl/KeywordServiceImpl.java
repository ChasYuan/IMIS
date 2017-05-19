package com.chas.service.Impl;

import com.chas.dao.KeywordDao;
import com.chas.model.Keyword;
import com.chas.service.KeywordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ShirUshI on 2017/5/13.
 */
@Service
public class KeywordServiceImpl implements KeywordService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KeywordDao keywordDao;

    public List<HashMap> selectAllKeywordWithDesc(){
        return keywordDao.selectAllKeywordWithDesc();
    }

    public void updateKeyword(Keyword keyword){
        keywordDao.updateKeyword(keyword);
    }

    public Keyword selectKeywordById(int id){
        return keywordDao.selectKeywordById(id);
    }

    public void deleteKeywordById(int id){
        keywordDao.deleteKeywordById(id);
    }

    public void insertKeyword(Keyword keyword){
        keywordDao.insertKeyword(keyword);
    }

    public List<HashMap> selectKeywordByKeyword(String keyword){
        return keywordDao.selectKeywordByKeyword(keyword);
    }

    public List<Keyword> selectAllKeyword(){
        return keywordDao.selectAllKeyword();
    }

    public List<String> selectAllWord(){
        return keywordDao.selectAllWord();
    }

    public Keyword selectKeywordByWord(String word){
        return keywordDao.selectKeywordByWord(word);
    }

    public HashMap selectASByWord(String word){
        return keywordDao.selectASByWord(word);
    }

    public List<String> selectWordByAS(int aspectId, int score){
        HashMap map = new HashMap();
        map.put("aspectId",aspectId);
        map.put("score",score);
        return keywordDao.selectWordByAS(map);
    }
}
