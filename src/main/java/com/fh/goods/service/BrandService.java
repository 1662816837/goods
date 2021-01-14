package com.fh.goods.service;

import com.fh.goods.entity.po.Brand;
import com.fh.goods.entity.vo.PageParam;

import java.util.Map;

public interface BrandService {
    public Map queryData(PageParam param);

    public Integer addData(Brand brand);

    public void updateDate(Brand brand);

    public void updateDateFalse(Brand brand);

    public Brand queryDataById(Integer id);
}
