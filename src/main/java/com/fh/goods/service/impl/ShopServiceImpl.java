package com.fh.goods.service.impl;

import com.fh.goods.dao.ShopDao;
import com.fh.goods.entity.po.Shop;
import com.fh.goods.entity.vo.PageParam;
import com.fh.goods.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao dao;

    @Override
    public void addData(Shop shop) {
        shop.setCreateDate(new Date());
        shop.setAuthor("admin");
        shop.setIsDel(0);
        dao.addData(shop);
    }

    @Override
    public Map queryDataLimit(PageParam param) {
        Map map = new HashMap();
        //先查询我们数据的总条数
        Long count = dao.queryCount(param);
        //构建我们的当前页的开始下标
        param.setStartIndex((param.getPage()-1)*param.getLimit());
        //查询到我们的分页数据
        List<Shop> list = dao.queryDataLimit(param);
        map.put("count",count);
        map.put("list",list);
        return map;
    }
}
