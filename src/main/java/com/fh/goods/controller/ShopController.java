package com.fh.goods.controller;

import com.fh.goods.entity.po.Shop;
import com.fh.goods.entity.vo.ReponseData;
import com.fh.goods.service.ShopService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("ShopController")
@CrossOrigin//这个注解是用来解决跨域问题的
public class ShopController {
    @Resource
    private ShopService ser;

    /*@PostMapping();
    public ReponseData queryDataLimit(){

    }*/
    @PostMapping("addData")
    public ReponseData addData(Shop shop){
        ser.addData(shop);
        return ReponseData.success(null);
    }
}
