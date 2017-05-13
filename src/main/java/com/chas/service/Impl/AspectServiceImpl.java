package com.chas.service.Impl;

import com.chas.dao.AspectDao;
import com.chas.model.Aspect;
import com.chas.service.AspectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/13.
 */
@Service
public class AspectServiceImpl implements AspectService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AspectDao aspectDao;

    public List<Aspect> selectAllAspect(){
        return aspectDao.selectAllAspect();
    }

}
