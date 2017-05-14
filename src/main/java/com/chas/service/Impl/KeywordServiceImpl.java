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
}
