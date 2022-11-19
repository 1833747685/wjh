package com.supermarket.controller;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.common.R;
import com.supermarket.pojo.Electrical;
import com.supermarket.service.ElectricalService;
import com.supermarket.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/electrical")
public class ElectricalController {
    @Autowired
    private ElectricalService electricalService;
    //分页查询数据
    @RequestMapping("/electricalList")
    public LayuiPageVo<Electrical> devicePageData(@RequestParam Map<String,Object> params){
        // 注意 这里使用 map来接受参数  前端传的不定参数 都可以封装到 map 中
        System.out.println(params);
        return electricalService.electricalPageData(params);
    }
    //添加商品信息
    @PostMapping("/addElectrical")
    public R addElectrical(Electrical electrical){
        System.out.println(electrical);

        int result = electricalService.addElectrical(electrical);
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
    @GetMapping("/deleteElectrical")
    public R deleteElectrical(Integer id){
        System.out.println(id);
        //根据id 删除药品信息
        int result = electricalService.deleteElectricalById(id);

        if(result==1){
            return R.ok();
        }else{
            return  R.error();
        }
    }
    //更新商品信息
    @PostMapping("/updateElectrical")
    public R updateDevice(Electrical electrical){
        System.out.println(electrical);

        int result = electricalService.updateElectrical(electrical);
        System.out.println(result);
        if(result==1){
            return R.ok();
        }else{
            return  R.error();
        }
    }
    //批量删除数据
    @PostMapping("/deleteAllElectrical")
    public R deleteAllDevice (String id) {
        System.out.println("id:"+id);
        int result = electricalService.deleteAllElectrical(id);

        if(result>=1){
            return R.ok();
        }else{
            return  R.error();
        }
    }
}
