package com.supermarket.mapper;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.SMeatpro;

import java.util.List;
import java.util.Map;

public interface SMeatproMapper {
    /**
     * 通过id 删除商品
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 通过对象插入商品
     * @param sMeatpro
     * @return
     */
    int insertByMeatpro(SMeatpro sMeatpro);

    /**
     * 通过对象更新数据
     * @param sMeatpro
     * @return
     */
    int updataByMeatpro(SMeatpro sMeatpro);

    /**
     * 查询所以和分页查询
     * @param params
     * @return
     */
    List<SMeatpro> selectAll(Map<String, Object> params);

    /**
     * 删除全部
     * @param id
     * @return
     */
    int deleteAll(Integer[] id);

//    /**
//     * 批量导出数据
//     * @param id
//     * @return
//     */
//    List<SMeatpro> findByIds(Integer[] id);
//
//    /**
//     * 全部导出数据
//     * @return
//     */
//    List<SMeatpro> findAll();
}