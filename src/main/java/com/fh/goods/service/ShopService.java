package com.fh.goods.service;

import com.fh.goods.entity.po.Shop;
import com.fh.goods.entity.vo.PageParam;

import java.util.Map;

public interface ShopService {
    public void addData(Shop shop);

    public Map queryDataLimit(PageParam param);

    public void updataData(Shop shop);

    public void updateDataById(Integer id);
}
