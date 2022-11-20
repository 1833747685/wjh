package com.supermarket.mapper;

import com.supermarket.pojo.Smokes;
import org.apache.ibatis.annotations.Delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SmokeMapper {

    List<Smokes> selectByParams(Map<String, Object> params);


    int addSmokes(Smokes smokes);
    @Delete("delete from s_smokes where sid =#{sid}")
    int deleteSmokes(Integer sid);

    int updateSmoke(Smokes smokes);

    int deleteAllSmoke(ArrayList<Integer> list);
}
