package com.supermarket.mapper;

import com.supermarket.pojo.Electrical;
import org.apache.ibatis.annotations.Delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ElectricalMapper {
    //分页查询
    List<Electrical> selectByParams(Map<String, Object> params);
    //添加
    int addElectrical(Electrical electrical);
    //根据id删除
    @Delete("delete from s_electrical where elid = #{id}")
    int deleteElectricalById(Integer id);

    int updateElectrical(Electrical electrical);

    int deleteAllElectrical(ArrayList<Integer> list);
}
