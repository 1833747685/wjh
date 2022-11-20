package com.supermarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarket.common.LayuiPageVo;
import com.supermarket.mapper.WineMapper;
import com.supermarket.pojo.Wine;
import com.supermarket.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("wineService")
public class WineServiceImpl implements WineService {

    @Autowired
    private WineMapper wineMapper;
    @Override
    public LayuiPageVo<Wine> winePageData(Map<String, Object> params) {
        Integer page = Integer.parseInt(params.get("page")+"");
        Integer limit = Integer.parseInt(params.get("limit")+"");
        PageHelper.startPage(page,limit);
        List<Wine> wines =wineMapper.selectByParams(params);
        System.out.println(wines);
        PageInfo<Wine> winesPageInfo = new PageInfo<>(wines);
        LayuiPageVo<Wine> winesLayuiPageVo = new LayuiPageVo<>();
        winesLayuiPageVo.setCode(0);
        winesLayuiPageVo.setMsg("酒水分页列表数据");
        winesLayuiPageVo.setCount(winesPageInfo.getTotal());  // 总记录数
        winesLayuiPageVo.setData(winesPageInfo.getList());  // 分页列表数据



        return winesLayuiPageVo;

    }

    @Override
    public int addWine(Wine wine) {
        return wineMapper.addWine(wine);
    }

    @Override
    public int deleteWine(Integer wid) {
        return wineMapper.deleteWine(wid);
    }

    @Override
    public int deleteAllWine(String wid) {
        String[] ids = wid.split(",");
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));

        }
        return wineMapper.deleteAllWine(list);
    }

    @Override
    public int updateWine(Wine wine) {
        return wineMapper.updateWine(wine);
    }
}

