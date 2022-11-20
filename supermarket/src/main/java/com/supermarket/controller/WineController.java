package com.supermarket.controller;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.common.R;
import com.supermarket.pojo.Smokes;
import com.supermarket.pojo.Wine;
import com.supermarket.service.WineService;
import com.supermarket.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/wine")
public class WineController {
    @Autowired
    private WineService wineService;

    @RequestMapping("/wineList")
    public LayuiPageVo<Wine> winePageData(@RequestParam Map<String,Object> params){
        System.out.println(params);
        return  wineService.winePageData(params);
    }

    @RequestMapping("/addWine")
    public R addWine(Wine Wine){
        System.out.println(Wine);

        int result =  wineService.addWine(Wine);

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
        System.out.println("upload");

        String fileUrl = OssUtil.uploadFile(file.getInputStream(),originalFilename);
        // 上传成功之后的文件地址 写给前端

        return R.ok().data("url",fileUrl);

    }
    @GetMapping("/deleteWine")
    public R deleteWine(Integer wid){
        int result = wineService.deleteWine(wid);

        if (result == 1){
            return R.ok();

        }else {
            return R.error();
        }
}
    @RequestMapping("/deleteAllWine")
    public R deleteAllWine(String wid){
        System.out.println("批量删除id" + wid);
        int i = wineService.deleteAllWine(wid);
        if (i > 0){
            return R.ok();
        }else {
            return R.error();
        }
}

    @RequestMapping("updateWine")
    public R editorWine(Wine wine) {
        System.out.println(wine);

        int result = wineService.updateWine(wine);
        if (result == 1) {
            return R.ok();

        } else {
            return R.error();
        }
    }
}
