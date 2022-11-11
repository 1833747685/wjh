package com.supermarket.service;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.Svip;

import java.util.Map;

public interface SvipService {
    LayuiPageVo<Svip> svipPageData(Map<String, Object> params);

    int addSvip(Svip svip);

    int deleteSvip(Integer vid);

    int deleteAllSvip(String vid);

    int updateSvip(Svip svip);
}
