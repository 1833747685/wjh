package com.supermarket.service;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.Electrical;

import java.util.Map;

public interface ElectricalService {
    LayuiPageVo<Electrical> electricalPageData(Map<String, Object> params);

    int addElectrical(Electrical electrical);

    int deleteElectricalById(Integer id);

    int updateElectrical(Electrical electrical);

    int deleteAllElectrical(String id);
}
