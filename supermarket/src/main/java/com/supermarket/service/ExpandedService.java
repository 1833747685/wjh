package com.supermarket.service;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.SExpanded;

import java.util.List;
import java.util.Map;

/**
 *
 */

public interface ExpandedService {

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
    int insertSelective(SExpanded record);

    /**
     * 查询所以和分页查询
     * @param params
     * @return
     */
    LayuiPageVo<SExpanded> selectAll(Map<String, Object> params);

    /**
     * 更新商品
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
