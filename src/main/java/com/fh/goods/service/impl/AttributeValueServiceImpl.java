package com.fh.goods.service.impl;

import com.fh.goods.dao.AttributeValueDao;
import com.fh.goods.entity.po.AttributeValue;
import com.fh.goods.service.AttributeValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttributeValueServiceImpl implements AttributeValueService {
    @Resource
    private AttributeValueDao dao;

    @Override
    public List<AttributeValue> queryDate(Integer attId) {
        List<AttributeValue> list = dao.queryDate(attId);
        return list;
    }

    @Override
    public void addData(AttributeValue attributeValue) {
        dao.addData(attributeValue);
    }

    @Override
    public void updateData(AttributeValue attributeValue) {
        dao.updateData(attributeValue);
    }
}
