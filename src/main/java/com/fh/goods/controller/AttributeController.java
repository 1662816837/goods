package com.fh.goods.controller;

import com.fh.goods.entity.vo.PageParam;
import com.fh.goods.entity.vo.ReponseData;
import com.fh.goods.service.AttributeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("AttributeController")
@CrossOrigin//这个注解是用来解决跨域问题的
public class AttributeController {
    @Resource
    private AttributeService ser;
    @GetMapping("queryData")
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
}
