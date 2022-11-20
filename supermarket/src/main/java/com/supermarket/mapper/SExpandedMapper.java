package com.supermarket.mapper;

import com.supermarket.pojo.SExpanded;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SExpandedMapper {
    /**
     * 删除单个商品
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加商品
     * @param record
     * @return
     */
    int insert(SExpanded record);


    /**
     * 查询所有加分页查询
     * @param params
     * @return
     */
    List<SExpanded> selectAll(Map<String, Object> params);

    /**
     * 商品更新
     * @param sExpanded
     * @return
     */
    int updataSExpanded(SExpanded sExpanded);

    /**
     * 批量删除
     * @param id
     * @return
     */
    int deleteAll(Integer[] id);
}