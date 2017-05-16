package com.chas.dao;

import com.chas.model.Shop;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/15.
 */
public interface ShopDao {

    List<Integer> selectAllShopId();

    List<Shop> selectAllShop();
}
