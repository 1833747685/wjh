package com.supermarket.controller;


import com.supermarket.common.LayuiPageVo;
import com.supermarket.common.R;
import com.supermarket.pojo.Svip;
import com.supermarket.pojo.Vip;
import com.supermarket.service.SvipService;
import com.supermarket.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/vmember")
public class SvipController {


    @Autowired
    private SvipService svipService;

    @RequestMapping("/svipList")
    public LayuiPageVo<Svip> vipList(@RequestParam Map<String,Object> params) {
        System.out.println(params);
        return svipService.svipPageData(params);
    }

    @PostMapping("/addSvip")
    public R addSvip(Svip svip){
        System.out.println("数据测试添加" + svip);
        int result = svipService.addSvip(svip);
        if (result == 1){
            return R.ok();
        }else {
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

    @GetMapping("/deleteSvip")
    public R deleteSvip (Integer vid){
        System.out.println("数据测试删除" + vid);

        int result = svipService.deleteSvip(vid);
        if (result == 1){
            return R.ok();
        }else {
            return R.error();
        }
    }
    @PostMapping("/deleteAllSvip")
    public R deleteAllSvip(String vid){
        System.out.println("数据测试批量删除" + vid);
        int i = svipService.deleteAllSvip(vid);
        if (i > 0){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @PostMapping("/updateSvip")
    public R updateSvip(Svip svip){
        System.out.println("数据测试修改" + svip);
        int result = svipService.updateSvip(svip);
        if (result == 1) {
            return R.ok();
        }else {
            return R.error();
        }
    }
}
