package com.supermarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarket.common.LayuiPageVo;
import com.supermarket.mapper.SvipMapper;
import com.supermarket.pojo.Svip;
import com.supermarket.pojo.Vip;
import com.supermarket.service.SvipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SvipServiceImpl implements SvipService {

    @Autowired
    private SvipMapper svipMapper;


    @Override
    public LayuiPageVo<Svip> svipPageData(Map<String, Object> params) {
        //mybatis 分页 插件的使用
        Integer page = Integer.parseInt(params.get("page") + "");
        Integer limit = Integer.parseInt(params.get("limit") + "");

        PageHelper.startPage(page, limit);
        List<Svip> svip = svipMapper.selectByParams(params);
        System.out.println(svip);

        // mybatis 的分页数据结构
        PageInfo<Svip> svipPageInfo = new PageInfo<>(svip);
        // 把mybatis 的分页数据结构中的 数据 封装到 layui的 分页数据结构中
        LayuiPageVo<Svip> svipLayuiPageVo = new LayuiPageVo<>();
        svipLayuiPageVo.setCode(0);
        svipLayuiPageVo.setMsg("特色菜分页列表数据");
        svipLayuiPageVo.setCount(svipPageInfo.getTotal());  // 总记录数
        svipLayuiPageVo.setData(svipPageInfo.getList());  // 分页列表数据

        return svipLayuiPageVo;
    }

    @Override
    public int addSvip(Svip svip) {
        return svipMapper.addSvip(svip);
    }

    @Override
    public int deleteSvip(Integer vid) {
        return svipMapper.deleteSvip(vid);
    }

    @Override
    public int deleteAllSvip(String vid) {
        String[] ids = vid.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
        }
        return svipMapper.deleteAllSvip(list);
    }

    @Override
    public int updateSvip(Svip svip) {
        return svipMapper.updateSvip(svip);
    }
}
