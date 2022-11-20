package com.supermarket.controller;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.common.R;
import com.supermarket.pojo.Toiletries;
import com.supermarket.service.ToiletriesService;
import com.supermarket.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/toiletries")
public class ToiletriesController {
    @Autowired
    private ToiletriesService toiletriesService;
    //分页查询数据
    @RequestMapping("/toiletriesList")
    public LayuiPageVo<Toiletries> devicePageData(@RequestParam Map<String,Object> params){
        // 注意 这里使用 map来接受参数  前端传的不定参数 都可以封装到 map 中
        System.out.println(params);
        return toiletriesService.toiletriesPageData(params);
    }
    //添加商品信息
    @PostMapping("/addToiletries")
    public R addToiletries(Toiletries toiletries){
        System.out.println(toiletries);

        int result = toiletriesService.addToiletries(toiletries);
        System.out.println(result);
        if(result==1){
            return R.ok();
        }else{
            return  R.error();
        }
    }
    //上传图片
    @PostMapping("/upload")
    public R uploadPic(MultipartFile file) throws IOException {
        //得到文件的名字
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);

        String fileUrl = OssUtil.uploadFile(file.getInputStream(),originalFilename);
        // 上传成功之后的文件地址 写给前端
        System.out.println(fileUrl);
        return R.ok().data("url",fileUrl);

    }
    //根据id删除数据
    @GetMapping("/deleteToiletries")
    public R deleteToiletries(Integer id){
        System.out.println(id);
        //根据id 删除药品信息
        int result = toiletriesService.deleteToiletriesById(id);

        if(result==1){
            return R.ok();
        }else{
            return  R.error();
        }
    }
    //更新商品信息
    @PostMapping("/updateToiletries")
    public R updateDevice(Toiletries toiletries){
        System.out.println(toiletries);

        int result = toiletriesService.updateToiletries(toiletries);
        System.out.println(result);
        if(result==1){
            return R.ok();
        }else{
            return  R.error();
        }
    }
    //批量删除数据
    @PostMapping("/deleteAllToiletries")
    public R deleteAllDevice (String id) {
        System.out.println("id:"+id);
        int result = toiletriesService.deleteAllToiletries(id);

        if(result>=1){
            return R.ok();
        }else{
            return  R.error();
        }
    }
}
