package com.supermarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarket.common.LayuiPageVo;
import com.supermarket.mapper.VipMapper;
import com.supermarket.pojo.Vip;
import com.supermarket.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    public LayuiPageVo<Vip> vipPageData(Map<String, Object> params) {
        //mybatis 分页 插件的使用
        Integer page = Integer.parseInt(params.get("page") + "");
        Integer limit = Integer.parseInt(params.get("limit") + "");

        PageHelper.startPage(page, limit);
        List<Vip> vip = vipMapper.selectByParams(params);
        System.out.println(vip);

        // mybatis 的分页数据结构
        PageInfo<Vip> hostPageInfo = new PageInfo<>(vip);
        // 把mybatis 的分页数据结构中的 数据 封装到 layui的 分页数据结构中
        LayuiPageVo<Vip> vipLayuiPageVo = new LayuiPageVo<>();
        vipLayuiPageVo.setCode(0);
        vipLayuiPageVo.setMsg("特色菜分页列表数据");
        vipLayuiPageVo.setCount(hostPageInfo.getTotal());  // 总记录数
        vipLayuiPageVo.setData(hostPageInfo.getList());  // 分页列表数据

        return vipLayuiPageVo;
    }

    @Override
    public int addVip(Vip vip) {
        return vipMapper.addVip(vip);
    }

    @Override
    public int deleteVip(Integer sid) {
        return vipMapper.deleteVip(sid);
    }

    @Override
    public int deleteAllVip(String sid) {
        String[] ids = sid.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));

        }
        return vipMapper.deleteAllVip(list);
    }

    @Override
    public int updateVip(Vip vip) {
        return vipMapper.updateVip(vip);
    }
}
