package com.supermarket.mapper;

import com.supermarket.pojo.Toiletries;
import org.apache.ibatis.annotations.Delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ToiletriesMapper {
    //分页查询
    List<Toiletries> selectByParams(Map<String, Object> params);
    //添加
    int addToiletries(Toiletries toiletries);
    //根据id删除
    @Delete("delete from s_toiletries where tid = #{id}")
    int deleteToiletriesById(Integer id);

    int updateToiletries(Toiletries toiletries);

    int deleteAllToiletries(ArrayList<Integer> list);
}
