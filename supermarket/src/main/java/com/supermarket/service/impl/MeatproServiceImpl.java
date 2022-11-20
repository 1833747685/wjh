package com.supermarket.service.impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarket.common.LayuiPageVo;
import com.supermarket.mapper.SMeatproMapper;
import com.supermarket.pojo.SMeatpro;
import com.supermarket.service.MeatproService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("/meatproService")
public class MeatproServiceImpl implements MeatproService {

    @Autowired
    private SMeatproMapper sMeatproMapper;

    @Override
    public int deleteById(Integer id) {
        return sMeatproMapper.deleteById(id);
    }

    @Override
    public int insertByMeatpro(SMeatpro sMeatpro) {
        return sMeatproMapper.insertByMeatpro(sMeatpro);
    }

    @Override
    public int updataByMeatpro(SMeatpro sMeatpro) {
        return sMeatproMapper.updataByMeatpro(sMeatpro);
    }

    @Override
    public LayuiPageVo<SMeatpro> selectAll(Map<String, Object> params) {
        //mybatis 分页 插件的使用 (前端传来的数据 limit 和 page)
        Integer page = Integer.parseInt(params.get("page") + "");
        Integer limit = Integer.parseInt(params.get("limit") + "");
        System.out.println(page + "," + limit);
        // 将前端传来的值 进行分页 分页工具PageHelper
        PageHelper.startPage(page, limit);

        //后端从数据库查出来的数据
        List<SMeatpro> sMeatpros = sMeatproMapper.selectAll(params);
        //这个是分页工具 固定写法 -> 这个是将查询的数据进行封装 到pageInfo 然后帮助获取Total 和 一些信息
        PageInfo<SMeatpro> sMeatproPageInfo = new PageInfo<>(sMeatpros);
        LayuiPageVo<SMeatpro> sMeatproLayuiPageVo = new LayuiPageVo<>();
        sMeatproLayuiPageVo.setCode(0);
        sMeatproLayuiPageVo.setMsg("商品分页");
        sMeatproLayuiPageVo.setCount(sMeatproPageInfo.getTotal());
        sMeatproLayuiPageVo.setData(sMeatproPageInfo.getList());
        return sMeatproLayuiPageVo;
    }

    @Override
    public int deleteAll(Integer[] id) {
        return sMeatproMapper.deleteAll(id);
    }

//    @Override
//    public void writeExcel(Integer[] id, HttpServletResponse response) {
//        //判断
//        if (id.length > 0) {
//            System.out.println("serviceimpl = writeExcel ===" + id.length);
//            //查询数据库
//            List<SMeatpro> MeatproList = sMeatproMapper.findByIds(id);
//            System.out.println("meatprolist=====================" + MeatproList);
//            //格式化当前时间
//            String currTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//            System.out.println("当前时间" + currTime);
//            //System.out.println("当前系统时间戳：" + System.currentTimeMillis());
//            // 写法2
//            //  弊端:
//            // 1. 只能全选才可以导出
//            // 2. 只能导出当前页 及其的不方便不可取
//            //String fileName = "D:/SMeatpro-" + System.currentTimeMillis() + ".xlsx";
//            //String fileName = "D:/SMeatpro-" + currTime + ".xlsx";
//            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//            // 如果这里想使用03 则 传入excelType参数即可
//            //EasyExcel.write(fileName, SMeatpro.class).sheet("患者列表").doWrite(MeatproList);
//
//
//            //通过下载的方式导出Excel文件
//            String fileName = "SMeatpro-" + currTime + ".xlsx";
//            System.out.println("fileName +++获取导出的文件名字+++" + fileName);
//            //设置响应头
//            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//            //通过流的方式写入
//            ServletOutputStream outputStream = null;
//            try {
//                outputStream = response.getOutputStream();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            //导出Excel
//            EasyExcel.write(outputStream, SMeatpro.class).sheet("肉制零食列表").doWrite(MeatproList);
//        } else {
//            //如果没有选择性导出数据，那么就导出所有
//            //查询数据库
//            List<SMeatpro> MeatproList = sMeatproMapper.findAll();
//            //格式化当前时间
//            String currTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//
//            //通过下载的方式导出Excel文件
//            String fileName = "SMeatpro-" + currTime + ".xlsx";
//            //设置响应头
//            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//            //通过流的方式写入
//            ServletOutputStream outputStream = null;
//            try {
//                outputStream = response.getOutputStream();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            //导出Excels
//            EasyExcel.write(outputStream, SMeatpro.class).sheet("肉制零食列表").doWrite(MeatproList);
//        }
//    }

}
