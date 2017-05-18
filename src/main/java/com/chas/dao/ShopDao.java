package com.chas.dao;

import com.chas.model.Shop;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ShirUshI on 2017/5/15.
 */
public interface ShopDao {

    List<Integer> selectAllShopId();

    List<Shop> selectAllShopByCommentNumDESC(HashMap map);

    int countAllShop();
    List<Shop> selectShopByCondition(HashMap map);

    int countShopByCondition(HashMap map);

    List<Shop> selectShopByKeyword(HashMap map);

    int countShopByKeyword(HashMap map);
}
