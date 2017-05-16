package com.chas.service;

import com.chas.model.City;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/16.
 */
public interface CityService {

    List<Integer> selectAllCityId();

    List<City> selectAllCity();
}
