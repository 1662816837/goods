package com.fh.goods.controller;

import com.fh.goods.entity.po.Brand;
import com.fh.goods.entity.vo.PageParam;
import com.fh.goods.entity.vo.ReponseData;
import com.fh.goods.service.BrandService;
import com.fh.goods.utils.OssFileUtils_yxr;
import com.fh.goods.utils.UploadDown;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("BrandController")
@CrossOrigin//这个注解是用来解决跨域问题的
public class BrandController {
    @Resource
    private BrandService ser;
    @Resource
    private HttpServletRequest request;
    @PostMapping("getData")
    public ReponseData queryData(PageParam param){
        if (param.getPage()==null){
            return ReponseData.error("page为毕传项，请重新发送请求");
        }
        if (param.getLimit()==null){
            return ReponseData.error("limt为毕传项，请重新发送请求");
        }
        Map list = ser.queryData(param);
        return ReponseData.success(list);
    }
    @PostMapping("addData")
    public ReponseData addData(Brand brand){
        Integer id = ser.addData(brand);
        return ReponseData.success(id);
    }
    @PostMapping("queryDataAll")
    public ReponseData queryDataAll(){
        List<Brand> list = ser.queryDataAll();
        return ReponseData.success(list);
    }

    /*
    *
    * */
    @PostMapping("updateDate")
    public ReponseData updateDate(Brand brand){
        ser.updateDate(brand);
        return ReponseData.success(null);
    }
    @PostMapping("deleteDate")
    public ReponseData deleteDate(Brand brand){
        if (brand.getId()==null){
            return ReponseData.error("id为毕传项，请重新发送请求");
        }
        brand.setIsdel(1);
        ser.updateDateFalse(brand);
        return ReponseData.success(null);
    }
    @PostMapping("uploadFile")
    public ReponseData uploadFile(@RequestParam("file") MultipartFile image) throws IOException {
        //处理新名称
        String originalFilename = image.getOriginalFilename();
        //防止中文引起的错误
        String newName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="images/"+newName;
        String s = OssFileUtils_yxr.uploadFile(image.getInputStream(), newName);
        System.out.println(s);
        return ReponseData.success(s);
    }
    @PostMapping("queryDataById")
    public ReponseData queryDataById(Integer id){
        Brand brand = ser.queryDataById(id);
        return ReponseData.success(brand);
    }
}
