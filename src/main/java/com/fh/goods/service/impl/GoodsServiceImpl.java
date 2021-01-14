package com.fh.goods.service.impl;

import com.fh.goods.dao.GoodsDao;
import com.fh.goods.entity.po.Goods;
import com.fh.goods.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao dao;

    @Override
    public List<Goods> queryData() {
        List<Goods> list = dao.queryData();
        return list;
    }

    @Override
    public List<Goods> queryDataByPid(Integer pid) {
        List<Goods> list = dao.queryDataByPid(pid);
        return list;
    }

    @Override
    public Integer addData(Goods goods) {
        goods.setCreateDate(new Date());
        goods.setIsDel(0);
        Integer id = dao.addData(goods);

        return goods.getId();
    }

    @Override
    public Goods queryDataById(Integer id) {
        Goods goo = dao.queryDataById(id);
        return goo;
    }

    @Override
    public void updateData(Goods goo) {
        dao.updateData(goo);
    }
}
