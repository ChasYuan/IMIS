package com.chas.dao;

import com.chas.model.Category;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
public interface CategoryDao  {

    List<String> selectAllCategoryId();

    List<Category> selectAllCategory();
}
