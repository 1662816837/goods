package com.fh.goods.service.impl;

import com.fh.goods.dao.BrandDao;
import com.fh.goods.entity.po.Brand;
import com.fh.goods.entity.vo.PageParam;
import com.fh.goods.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao dao;

    @Override
    public Map queryData(PageParam param) {
        Map map = new HashMap();
        //先查询总条数
        Long count = dao.queryCount(param);
        //给当前页的其实下标赋值
        param.setStartIndex((param.getPage()-1)*param.getLimit());
        List<Brand> list  = dao.queryData(param);
        //构建我们的返回值
        map.put("count",count);
        map.put("list",list);
        return map;
    }

    @Override
    public Integer addData(Brand brand) {
        brand.setCreateDate(new Date());
        brand.setAuthor("admin");
        brand.setIsdel(0);
        Integer id = dao.addData(brand);
        return brand.getId();
    }

    @Override
    public void updateDate(Brand brand) {
        brand.setAuthor("admin");
        brand.setUpdateDate(new Date());
        dao.updateDate(brand);
    }

    @Override
    public void updateDateFalse(Brand brand) {
        dao.updateDateFalse(brand);
    }

    @Override
    public Brand queryDataById(Integer id) {
        Brand brand = dao.queryDataById(id);
        return brand;
    }
}
