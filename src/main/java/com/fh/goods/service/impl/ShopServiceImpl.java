package com.fh.goods.service.impl;

import com.fh.goods.dao.ShopDao;
import com.fh.goods.entity.po.Shop;
import com.fh.goods.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
}
