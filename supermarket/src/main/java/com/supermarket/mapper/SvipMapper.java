package com.supermarket.mapper;

import com.supermarket.pojo.Svip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SvipMapper {
    List<Svip> selectByParams(Map<String, Object> params);

    int addSvip(Svip svip);

    int deleteSvip(Integer vid);

    int deleteAllSvip(ArrayList<Integer> list);

    int updateSvip(Svip svip);
}
