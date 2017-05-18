package com.chas.service;

import com.chas.model.Shop;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ShirUshI on 2017/5/15.
 */
public interface ShopService {
    List<Integer> selectAllShopId();

    List<Shop> selectAllShopByCommentNumDESC(int pageIndex);

    int countAllShop();

    List<Shop> selectShopByCondition(String city, String category, String cond, String queue,int index, int size);

    int countShopByCondition(String city, String category);

    List<Shop> selectShopByKeyword(String city, String category, String keyword, String cond, String queue, int index, int size);

    int countShopByKeyword(String city, String category, String keyword);
}
