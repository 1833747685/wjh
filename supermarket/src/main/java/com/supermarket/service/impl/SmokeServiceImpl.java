package com.supermarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarket.common.LayuiPageVo;
import com.supermarket.mapper.SmokeMapper;
import com.supermarket.pojo.Smokes;
import com.supermarket.service.SmokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service("smokeService")
public class SmokeServiceImpl implements SmokeService {
    @Autowired
    private SmokeMapper smokeMapper;

    @Override
    public LayuiPageVo<Smokes> smokePageData(Map<String, Object> params) {
        Integer page = Integer.parseInt(params.get("page")+"");
        Integer limit = Integer.parseInt(params.get("limit")+"");
        PageHelper.startPage(page,limit);
        List<Smokes> smokes =  smokeMapper.selectByParams(params);
        System.out.println(smokes);
        PageInfo<Smokes> smokesPageInfo = new PageInfo<>(smokes);
        LayuiPageVo<Smokes> smokeLayuiPageVo = new LayuiPageVo<>();
        smokeLayuiPageVo.setCode(0);
        smokeLayuiPageVo.setMsg("蔬菜分页列表数据");
        smokeLayuiPageVo.setCount(smokesPageInfo.getTotal());  // 总记录数
        smokeLayuiPageVo.setData(smokesPageInfo.getList());  // 分页列表数据



        return smokeLayuiPageVo;

    }

    @Override
    public int addSmokes(Smokes smokes) {
        return smokeMapper.addSmokes(smokes);
    }

    @Override
    public int deleteSmoke(Integer sid) {
        return smokeMapper.deleteSmokes(sid);
    }

    @Override
    public int updateSmoke(Smokes smokes) {
        return smokeMapper.updateSmoke(smokes);
    }

    @Override
    public int deleteAllSmoke(String sid) {
        String[] ids = sid.split(",");
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));

        }
        return smokeMapper.deleteAllSmoke(list);
    }
    }

