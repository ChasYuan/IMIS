package com.chas.service.Impl;

import com.chas.dao.CategoryDao;
import com.chas.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryDao categoryDao;

    public List<String> selectAllCategoryId() {
        return categoryDao.selectAllCategoryId();
    }
}
