package com.chas.service.Impl;

import com.chas.dao.CommentDao;
import com.chas.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ShirUshI on 2017/5/16.
 */
@Service
public class CommentServiceImpl implements CommentService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentDao commentDao;

}
