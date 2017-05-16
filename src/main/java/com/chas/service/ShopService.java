package com.chas.service;

import com.chas.model.Shop;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/15.
 */
public interface ShopService {
    List<Integer> selectAllShopId();

    List<Shop> selectAllShop();
}
