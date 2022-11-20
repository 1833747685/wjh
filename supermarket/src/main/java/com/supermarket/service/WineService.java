package com.supermarket.service;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.Wine;

import java.util.Map;

public interface WineService {
    LayuiPageVo<Wine> winePageData(Map<String, Object> params);

    int addWine(Wine wine);

    int deleteWine(Integer wid);

    int deleteAllWine(String wid);

    int updateWine(Wine wine);
}
