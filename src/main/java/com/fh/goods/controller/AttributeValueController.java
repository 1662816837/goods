package com.fh.goods.controller;

import com.fh.goods.entity.po.AttributeValue;
import com.fh.goods.entity.vo.ReponseData;
import com.fh.goods.service.AttributeValueService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("AttributeValueController")
@CrossOrigin//这个注解是用来解决跨域问题的
public class AttributeValueController {
    @Resource
    private AttributeValueService ser;
    @PostMapping("queryDate")
    public ReponseData queryDate(Integer attId){
        if (attId==null){
            return ReponseData.success("attId为必传项");
        }
        List<AttributeValue> list = ser.queryDate(attId);
        return ReponseData.success(list);
    }
}
