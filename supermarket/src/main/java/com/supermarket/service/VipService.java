package com.supermarket.service;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.Vip;

import java.util.Map;

public interface VipService {
    LayuiPageVo<Vip> vipPageData(Map<String, Object> params);

    int addVip(Vip vip);

    int deleteVip(Integer sid);

    int deleteAllVip(String sid);

    int updateVip(Vip vip);
}
