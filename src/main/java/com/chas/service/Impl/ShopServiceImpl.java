package com.chas.service.Impl;

import com.chas.dao.ShopDao;
import com.chas.model.Shop;
import com.chas.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Shop> selectAllShopByCommentNumDESC(int pageIndex){
        HashMap map = new HashMap();
        int index = (pageIndex - 1) * 30;
        int size = 30;
        map.put("index",index);
        map.put("size",size);
        return shopDao.selectAllShopByCommentNumDESC(map);
    }

    public int countAllShop(){
        return shopDao.countAllShop();
    }

    public List<Shop> selectShopByCondition(String city, String category, String cond, String queue,int index, int size){
       HashMap map = new HashMap();
       index = (index - 1) * 30;
       if(!city.equals(""))
           map.put("city",city);
       if(!category.equals(""))
           map.put("category",category);
       if(!cond.equals(""))
           map.put("cond",cond);
       if(!queue.equals(""))
           map.put("queue",queue);
       map.put("index",index);
       map.put("size",size);
       return shopDao.selectShopByCondition(map);
    }

    public int countShopByCondition(String city, String category){
        HashMap map = new HashMap();
        if(!city.equals(""))
            map.put("city",city);
        if(!category.equals(""))
            map.put("category",category);
        return shopDao.countShopByCondition(map);
    }

}
