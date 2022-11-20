package com.supermarket.controller;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.common.R;
import com.supermarket.pojo.Smokes;
import com.supermarket.service.SmokeService;
import com.supermarket.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/smoke")
public class SmokeController {
    @Autowired
    private SmokeService smokeService;

    @RequestMapping("/smokeList")
    public LayuiPageVo<Smokes> smokePageData(@RequestParam Map<String,Object> params){
        System.out.println(params);
        return  smokeService.smokePageData(params);
    }



    @RequestMapping("/addSmoke")
    public R addSmokes(Smokes smokes){
        System.out.println(smokes);

        int result =  smokeService.addSmokes(smokes);

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

    @GetMapping("/deleteSmoke")
    public R deleteSmoke(Integer sid){
        int result = smokeService.deleteSmoke(sid);

        if (result == 1){
            return R.ok();

        }else {
            return R.error();
        }

}
    @RequestMapping("updateSmoke")
    public R editorStudent(Smokes smokes){
        System.out.println(smokes);

        int result =  smokeService.updateSmoke(smokes);
        if (result == 1){
            return R.ok();

        }else {
            return R.error();
        }


}
    @RequestMapping("/deleteAllSmoke")
    public R deleteAllSmoke(String sid){
        System.out.println("批量删除id" + sid);
        int i = smokeService.deleteAllSmoke(sid);
        if (i > 0){
            return R.ok();
        }else {
            return R.error();
        }

}
}
