package com.chas.service.Impl;

import com.chas.dao.CityDao;
import com.chas.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
@Service
public class CityServiceImpl implements CityService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityDao cityDao;

    public List<Integer> selectAllCityId(){
        return cityDao.selectAllCityId();
    }

}
