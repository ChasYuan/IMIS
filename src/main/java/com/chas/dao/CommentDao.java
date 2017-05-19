package com.chas.dao;

import com.chas.model.Comment;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
public interface CommentDao {

    List<Comment> selectCommentByShopId(int id);

    List<Integer> selectYearByShopId(int id);
}
