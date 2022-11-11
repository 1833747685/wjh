package com.supermarket.mapper;

import com.supermarket.pojo.Vip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface VipMapper {
    List<Vip> selectByParams(Map<String, Object> params);

    int addVip(Vip vip);

    int deleteVip(Integer sid);

    int deleteAllVip(ArrayList<Integer> list);

    int updateVip(Vip vip);
}
