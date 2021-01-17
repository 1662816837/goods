package com.fh.goods.dao;

import com.fh.goods.entity.po.AttributeValue;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttributeValueDao {
    @Select("select * from attributeValue where attId = #{id}")
    public List<AttributeValue> queryDate(Integer attId);
}
