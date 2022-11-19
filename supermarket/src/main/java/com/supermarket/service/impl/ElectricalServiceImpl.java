package com.supermarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarket.common.LayuiPageVo;
import com.supermarket.mapper.ElectricalMapper;
import com.supermarket.pojo.Electrical;
import com.supermarket.service.ElectricalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("electricalService")
public class ElectricalServiceImpl implements ElectricalService {
    @Autowired
    private ElectricalMapper electricalMapper;
    @Override
    public LayuiPageVo<Electrical> electricalPageData(Map<String, Object> params) {
        //mybatis 分页 插件的使用
        Integer page = Integer.parseInt(params.get("page")+"");
        Integer limit = Integer.parseInt(params.get("limit")+"");
        PageHelper.startPage(page,limit);
        List<Electrical> device =  electricalMapper.selectByParams(params);
//        System.out.println(device);
        // mybatis 的分页数据结构
        PageInfo<Electrical> drugPageInfo = new PageInfo<>(device);
        // 把mybatis 的分页数据结构中的 数据 封装到 layui的 分页数据结构中
        LayuiPageVo<Electrical> drugLayuiPageVo = new LayuiPageVo<>();
        drugLayuiPageVo.setCode(0);
        drugLayuiPageVo.setMsg("洗漱用品分页列表数据");
        drugLayuiPageVo.setCount(drugPageInfo.getTotal());  // 总记录数
        drugLayuiPageVo.setData(drugPageInfo.getList());  // 分页列表数据

        return drugLayuiPageVo;
    }

    @Override
    public int addElectrical(Electrical electrical) {
        System.out.println(electrical);
        return electricalMapper.addElectrical(electrical);
    }

    @Override
    public int deleteElectricalById(Integer id) {
        return electricalMapper.deleteElectricalById(id);
    }

    @Override
    public int updateElectrical(Electrical electrical) {
        System.out.println(electrical);
        return electricalMapper.updateElectrical(electrical);
    }

    @Override
    public int deleteAllElectrical(String id) {
        String[] ids = id.split( ",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0; i< ids.length; i++){
            list.add(Integer.parseInt(ids[i]));
        }
        return electricalMapper.deleteAllElectrical(list);
    }
}
