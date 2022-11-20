package com.supermarket.service;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.pojo.SMeatpro;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface MeatproService {
    /**
     * 删除单个商品
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 添加商品
     * @param sMeatpro
     * @return
     */
    int insertByMeatpro(SMeatpro sMeatpro);

    /**
     * 更新商品
     * @param sMeatpro
     * @return
     */
    int updataByMeatpro(SMeatpro sMeatpro);

    /**
     * 查询所有和分页查询
     * @param params
     * @return
     */
    LayuiPageVo<SMeatpro> selectAll(Map<String, Object> params);

    /**
     * 批量删除
     * @param id
     * @return
     */
    int deleteAll(Integer[] id);

//    /**
//     * 表格导出
//     * @param id
//     * @param response
//     */
//    void writeExcel(Integer[] id, HttpServletResponse response);
}
