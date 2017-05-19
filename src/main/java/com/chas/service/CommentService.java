package com.chas.service;

import com.chas.model.Comment;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
public interface CommentService {

    List<Comment> selectCommentByShopId(int id);

    List<Integer> selectYearByShopId(int id);
}
