package com.fh.goods.service.impl;

import com.fh.goods.dao.AttributeDao;
import com.fh.goods.entity.po.Attribute;
import com.fh.goods.entity.po.Brand;
import com.fh.goods.entity.vo.PageParam;
import com.fh.goods.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    private AttributeDao dao;

    @Override
    public Map queryData(PageParam param) {
       Map map = new HashMap();
        //先查询总条数
        Long count = dao.queryCount(param);
        //给当前页的其实下标赋值
        param.setStartIndex((param.getPage()-1)*param.getLimit());
        List<Attribute> list  = dao.queryData(param);
        map.put("count",count);
        map.put("list",list);
       return map;
    }
}
