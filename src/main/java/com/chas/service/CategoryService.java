package com.chas.service;

import com.chas.model.Category;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
public interface CategoryService {

    List<String> selectAllCategoryId();

    List<Category> selectAllCategory();

}
