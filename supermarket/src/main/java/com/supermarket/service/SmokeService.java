package com.supermarket.service;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.Smokes;

import java.util.Map;

public interface SmokeService {
    LayuiPageVo<Smokes> smokePageData(Map<String, Object> params);

    int addSmokes(Smokes smokes);

    int deleteSmoke(Integer sid);

    int updateSmoke(Smokes smokes);

    int deleteAllSmoke(String sid);
}
