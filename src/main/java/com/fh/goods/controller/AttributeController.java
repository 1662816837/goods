package com.fh.goods.controller;

import com.fh.goods.entity.po.Attribute;
import com.fh.goods.entity.vo.PageParam;
import com.fh.goods.entity.vo.ReponseData;
import com.fh.goods.service.AttributeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("AttributeController")
@CrossOrigin//这个注解是用来解决跨域问题的
public class AttributeController {
    @Resource
    private AttributeService ser;
    /*
    *
    * */
    @PostMapping("queryData")
    public ReponseData queryData(PageParam param){
        if (param.getPage()==null){
            return ReponseData.error("page为毕传项，请重新发送请求");
        }
        if (param.getLimit()==null){
            return ReponseData.error("limt为毕传项，请重新发送请求");
        }
        Map map = ser.queryData(param);
        return ReponseData.success(map);
    }
    @PostMapping("addData")
    public ReponseData addData(Attribute attribute){
        if(attribute==null){
            return ReponseData.error("值最少为一个");
        }
        Integer id = ser.addData(attribute);
        return ReponseData.success(id);
    }
}
