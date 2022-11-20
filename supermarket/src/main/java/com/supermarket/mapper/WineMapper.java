package com.supermarket.mapper;

import com.supermarket.pojo.Wine;
import org.apache.ibatis.annotations.Delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface WineMapper {
    List<Wine> selectByParams(Map<String, Object> params);

    int addWine(Wine wine);
    @Delete("delete from s_wine where wid =#{wid}")
    int deleteWine(Integer wid);

    int deleteAllWine(ArrayList<Integer> list);

    int updateWine(Wine wine);
}
