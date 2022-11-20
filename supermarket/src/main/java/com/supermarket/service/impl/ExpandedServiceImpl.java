package com.supermarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarket.common.LayuiPageVo;
import com.supermarket.mapper.SExpandedMapper;
import com.supermarket.pojo.SExpanded;
import com.supermarket.service.ExpandedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("/expandedService")
public class ExpandedServiceImpl implements ExpandedService {
    @Autowired
    private SExpandedMapper sExpandedMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sExpandedMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SExpanded record) {
        return sExpandedMapper.insert(record);
    }


    @Override
    public LayuiPageVo<SExpanded> selectAll(Map<String, Object> params) {
        //mybatis 分页 插件的使用
        Integer page = Integer.parseInt(params.get("page") + "");
        Integer limit = Integer.parseInt(params.get("limit") + "");
        System.out.println(page + "," + limit);
        PageHelper.startPage(page, limit);
        //将查询的对象存放进集合中
        List<SExpanded> expandeds = sExpandedMapper.selectAll(params);
        // mybatis 的分页数据结构
        PageInfo<SExpanded> studentPageInfo = new PageInfo<>(expandeds);
        // 把mybatis 的分页数据结构中的 数据 封装到 layui的 分页数据结构中
        LayuiPageVo<SExpanded> sExpandedListsLayuiPageVo = new LayuiPageVo<>();

        sExpandedListsLayuiPageVo.setCode(0); //
        sExpandedListsLayuiPageVo.setMsg("小区分页数据"); //分页信息
        sExpandedListsLayuiPageVo.setCount(studentPageInfo.getTotal());  // 总记录数
        sExpandedListsLayuiPageVo.setData(studentPageInfo.getList());  // 分页列表数据
        return sExpandedListsLayuiPageVo;
    }

    @Override
    public int updataSExpanded(SExpanded sExpanded) {
        return sExpandedMapper.updataSExpanded(sExpanded);
    }

    @Override
    public int deleteAll(Integer[] id) {
        return sExpandedMapper.deleteAll(id);
    }


}
