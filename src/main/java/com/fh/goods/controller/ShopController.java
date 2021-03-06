package com.fh.goods.controller;

import com.fh.goods.entity.po.Shop;
import com.fh.goods.entity.vo.PageParam;
import com.fh.goods.entity.vo.ReponseData;
import com.fh.goods.service.ShopService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("ShopController")
@CrossOrigin//这个注解是用来解决跨域问题的
public class ShopController {
    @Resource
    private ShopService ser;

   @PostMapping("queryDataLimit")
    public ReponseData queryDataLimit(PageParam param){
       if (param.getLimit()==null){
           return ReponseData.error("limit为必传项");
       }
       if(param.getPage()==null){
           return ReponseData.error("page为必传项");
       }
       Map map = ser.queryDataLimit(param);
    return ReponseData.success(map);
    }
    @PostMapping("queryDataById")
    public ReponseData queryDataById(Integer id){
        Shop shop = ser.queryDataById(id);
       return  ReponseData.success(shop);
    }


    //商品新增  完整】
    @PostMapping("addDataSku")
    public ReponseData addDataSku(Shop shop,String attr,String sku){
       //传过来 步骤一的form表单数据  attr是我们的spu数据   sku是我们的选项选择完成只收生成的sku表格数据
       ser.addDataSku(shop,attr,sku);
    return ReponseData.success(null);
    }

    @PostMapping("addData")
    public ReponseData addData(Shop shop){
       if (shop==null){
           return ReponseData.error("最少新增一个值");
       }
        ser.addData(shop);
        return ReponseData.success(null);
    }
    @PostMapping("updataData")
    public ReponseData updataData(Shop shop){
       if (shop.getId()==null){
           return ReponseData.error("id为必传项，不能为空");
       }
       ser.updataData(shop);
       return ReponseData.success(null);
    }

    @PostMapping("updateDataById")
    public ReponseData updateDataById(Integer id){
       ser.updateDataById(id);
       return ReponseData.success(null);
    }
}
