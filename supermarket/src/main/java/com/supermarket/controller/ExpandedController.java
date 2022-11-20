package com.supermarket.controller;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.common.R;
import com.supermarket.pojo.SExpanded;
import com.supermarket.service.ExpandedService;
import com.supermarket.controller.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/expanded")
public class ExpandedController {

    @Autowired
    private ExpandedService expandedService;

    /**
     * 模糊查询和分页
     *
     * @param params
     * @return
     */
    @RequestMapping("/selectAll")

    public LayuiPageVo<SExpanded> selectAll(@RequestParam Map<String, Object> params) {
        System.out.println("selectAll params====" + params);
        LayuiPageVo<SExpanded> result = expandedService.selectAll(params);
        return result;
    }

    /**
     * 更新商品
     *
     * @param sExpanded
     * @return
     */
    @RequestMapping("/updata")
    public R update(SExpanded sExpanded) {
        System.out.println("updata  =====" + sExpanded);
        int i = expandedService.updataSExpanded(sExpanded);
        if (i >= 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteByPrimaryKey")
    public R deleteByPrimaryKey(Integer id) {
        System.out.println("deleteByPrimaryKey======" + id);
        int i = expandedService.deleteByPrimaryKey(id);
        if (i >= 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 添加商品
     *
     * @param record
     * @return
     */
    @RequestMapping("/insert")
    public R insert(SExpanded record) {
        System.out.println("insert ===" + record);
        int insert = expandedService.insertSelective(record);
        if (insert >= 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping("/deleteAll")
    public R deleteAll(Integer[] id) {
        System.out.println("deleteAll 11111====" + id);
        if (id != null) {
            int i = expandedService.deleteAll(id);
            if (i > 0) {
                return R.ok();
            } else {
                return R.error();
            }
        } else {
            return R.error();
        }
    }


    @PostMapping("/upload")
    public R uploadPic(MultipartFile file) throws IOException {
        //得到文件的名字
        String originalFilename = file.getOriginalFilename();

        String fileUrl = OssUtil.uploadFile(file.getInputStream(), originalFilename);
        // 上传成功之后的文件地址 写给前端

        return R.ok().data("url",fileUrl);

    }
}
