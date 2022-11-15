package com.supermarket.service;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.Toiletries;

import java.util.Map;

public interface ToiletriesService {
    LayuiPageVo<Toiletries> toiletriesPageData(Map<String, Object> params);

    int addToiletries(Toiletries toiletries);

    int deleteToiletriesById(Integer id);

    int updateToiletries(Toiletries toiletries);

    int deleteAllToiletries(String id);
}
