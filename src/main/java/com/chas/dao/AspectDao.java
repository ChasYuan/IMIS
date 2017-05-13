package com.chas.dao;

import com.chas.model.Aspect;

import java.util.List;

/**
 * Created by ShirUshI on 2017/5/13.
 */
public interface AspectDao {
    List<Aspect> selectAllAspect();
}
