package com.fh.goods.service;

import com.fh.goods.entity.po.AttributeValue;

import java.util.List;

public interface AttributeValueService {
    public List<AttributeValue> queryDate(Integer attId);

    public void addData(AttributeValue attributeValue);

    public void updateData(AttributeValue attributeValue);

    public void updataById(Integer id);

    public AttributeValue queryDataById(Integer id);
}
