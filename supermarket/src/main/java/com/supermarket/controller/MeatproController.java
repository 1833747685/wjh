package com.supermarket.controller;

import com.supermarket.common.LayuiPageVo;
import com.supermarket.common.R;
import com.supermarket.pojo.SMeatpro;
import com.supermarket.service.MeatproService;
import com.supermarket.controller.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/meat")
public class MeatproController {
    @Autowired
    private MeatproService meatproService;

    @RequestMapping("/selectAll")
    public LayuiPageVo<SMeatpro> selectAll(@RequestParam Map<String, Object> params) {
        return meatproService.selectAll(params);
    }

    @RequestMapping("/updata")
    public R updataByMeatpro(SMeatpro sMeatpro) {
        int i = meatproService.updataByMeatpro(sMeatpro);
        if (i >= 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping("/insert")
    public R insertByMeatpro(SMeatpro sMeatpro) {
        int i = meatproService.insertByMeatpro(sMeatpro);
        if (i >= 0) {
            return R.ok();
        } else {
            return R.error();
        }

    }

    @RequestMapping("/deleteByPrimaryKey")
    public R deleteById(Integer id) {
        int i = meatproService.deleteById(id);
        if (i >= 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping("/deleteAll")
    public R deleteAll(Integer[] id) {
        System.out.println("deleteAll =====" + Arrays.toString(id));
        if (id.length > 0) {
            int i = meatproService.deleteAll(id);
            System.out.println("delete =============返回" + i);
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

        return R.ok().data("url", fileUrl);
    }

//    @RequestMapping("/writeExcel")
//    public void writeExcel(Integer [] mid , HttpServletResponse response){
//        System.out.println("writeExcel" + Arrays.toString(mid));
//        meatproService.writeExcel(mid,response);
//    }
}
