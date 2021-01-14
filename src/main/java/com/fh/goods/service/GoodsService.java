package com.fh.goods.service;

import com.fh.goods.entity.po.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> queryData();

    public List<Goods> queryDataByPid(Integer pid);

    public Integer addData(Goods goods);

    public Goods queryDataById(Integer id);

    public void updateData(Goods goo);
}
