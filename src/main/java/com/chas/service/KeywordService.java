package com.chas.service;

import com.chas.model.Keyword;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ShirUshI on 2017/5/13.
 */
public interface KeywordService {

    List<HashMap> selectAllKeywordWithDesc();

    void updateKeyword(Keyword keyword);

    Keyword selectKeywordById(int id);

    void deleteKeywordById(int id);

    void insertKeyword(Keyword keyword);

    List<HashMap> selectKeywordByKeyword(String keyword);
}
