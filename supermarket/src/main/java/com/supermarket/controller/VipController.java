package com.supermarket.controller;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.common.R;
import com.supermarket.pojo.Vip;
import com.supermarket.service.VipService;
import com.supermarket.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class VipController {

    @Autowired
    private VipService vipService;

    @RequestMapping("/vipList")

    public LayuiPageVo<Vip> vipList(@RequestParam Map<String,Object> params) {
        System.out.println(params);
        return vipService.vipPageData(params);
    }

    @PostMapping("/addVip")

    public R addVip (Vip vip){
        System.out.println("测试添加数据" + vip);
        int result = vipService.addVip(vip);
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

    @GetMapping("/deleteVip")
    public R deleteVip(Integer sid){
        System.out.println("测试删除数据" + sid);
        int result = vipService.deleteVip(sid);
        if (result == 1){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @PostMapping("/deleteAllVip")
    public R deleteAllVip(String sid){
        System.out.println("批量删除id" + sid);
        int i = vipService.deleteAllVip(sid);
        if (i > 0){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @PostMapping("/updateVip")
    public R updateVip(Vip vip){
        System.out.println("测试编辑数据" + vip);
        int result = vipService.updateVip(vip);
        if (result == 1){
            return R.ok();
        }else {
            return R.error();
        }
    }


}
