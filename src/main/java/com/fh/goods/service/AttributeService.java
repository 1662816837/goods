package com.fh.goods.service;

import com.fh.goods.entity.po.Attribute;
import com.fh.goods.entity.vo.PageParam;

import java.util.List;
import java.util.Map;

public interface AttributeService {
    public Map queryData(PageParam param);

    public Integer addData(Attribute attribute);

    public void updateData(Attribute attribute);

    public void updateDataById(Integer id);

    public Attribute queryDataById(Integer id);

    public List<Attribute> queryDataBuTypeId(Integer typeId);
}
