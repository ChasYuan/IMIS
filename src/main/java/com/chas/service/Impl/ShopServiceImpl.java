package com.chas.service.Impl;

import com.chas.dao.ShopDao;
import com.chas.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/15.
 */
@Service
public class ShopServiceImpl implements ShopService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ShopDao shopDao;

    public List<Integer> selectAllShopId(){
        return shopDao.selectAllShopId();
    }

}
