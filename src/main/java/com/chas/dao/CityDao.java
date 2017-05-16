package com.chas.dao;

import com.chas.model.City;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
public interface CityDao {

    List<Integer> selectAllCityId();

    List<City> selectAllCity();

}
