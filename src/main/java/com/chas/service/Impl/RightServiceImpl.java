package com.chas.service.Impl;

import com.chas.dao.RightDao;
import com.chas.model.Right;
import com.chas.service.RightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/12.
 */
@Service
public class RightServiceImpl implements RightService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RightDao rightDao;

    public List<Right> selectAllRight(){
        return rightDao.selectAllRight();
    }
}
