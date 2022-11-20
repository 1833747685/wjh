package com.supermarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarket.common.LayuiPageVo;
import com.supermarket.mapper.ToiletriesMapper;
import com.supermarket.pojo.Toiletries;
import com.supermarket.service.ToiletriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("toiletriesService")
public class ToiletriesServiceImpl implements ToiletriesService {
    @Autowired
    private ToiletriesMapper toiletriesMapper;
    @Override
    public LayuiPageVo<Toiletries> toiletriesPageData(Map<String, Object> params) {
        //mybatis 分页 插件的使用
        Integer page = Integer.parseInt(params.get("page")+"");
        Integer limit = Integer.parseInt(params.get("limit")+"");
        PageHelper.startPage(page,limit);
        List<Toiletries> device =  toiletriesMapper.selectByParams(params);
//        System.out.println(device);
        // mybatis 的分页数据结构
        PageInfo<Toiletries> drugPageInfo = new PageInfo<>(device);
        // 把mybatis 的分页数据结构中的 数据 封装到 layui的 分页数据结构中
        LayuiPageVo<Toiletries> drugLayuiPageVo = new LayuiPageVo<>();
        drugLayuiPageVo.setCode(0);
        drugLayuiPageVo.setMsg("洗漱用品分页列表数据");
        drugLayuiPageVo.setCount(drugPageInfo.getTotal());  // 总记录数
        drugLayuiPageVo.setData(drugPageInfo.getList());  // 分页列表数据

        return drugLayuiPageVo;
    }

    @Override
    public int addToiletries(Toiletries toiletries) {
        System.out.println(toiletries);
        return toiletriesMapper.addToiletries(toiletries);
    }

    @Override
    public int deleteToiletriesById(Integer id) {
        return toiletriesMapper.deleteToiletriesById(id);
    }

    @Override
    public int updateToiletries(Toiletries toiletries) {
        System.out.println(toiletries);
        return toiletriesMapper.updateToiletries(toiletries);
    }

    @Override
    public int deleteAllToiletries(String id) {
        String[] ids = id.split( ",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0; i< ids.length; i++){
            list.add(Integer.parseInt(ids[i]));
        }
        return toiletriesMapper.deleteAllToiletries(list);
    }
}
