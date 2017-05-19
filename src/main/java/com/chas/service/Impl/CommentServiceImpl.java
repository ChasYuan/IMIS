package com.chas.service.Impl;

import com.chas.dao.CommentDao;
import com.chas.model.Comment;
import com.chas.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
@Service
public class CommentServiceImpl implements CommentService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentDao commentDao;

    public List<Comment> selectCommentByShopId(int id){
        return commentDao.selectCommentByShopId(id);
    }

    public List<Integer> selectYearByShopId(int id){
        return commentDao.selectYearByShopId(id);
    }
}
