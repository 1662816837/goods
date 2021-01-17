package com.fh.goods.dao;

import com.fh.goods.entity.po.AttributeValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttributeValueDao {
    @Select("select * from attributeValue where attId = #{id}")
    public List<AttributeValue> queryDate(Integer attId);
    @Insert("insert into attributeValue (name,nameCH,attId,isdel) values (#{name},#{nameCH},#{attId},0)")
    public void addData(AttributeValue attributeValue);
    @Update("update  attributeValue set name = #{name},nameCH = #{nameCH} where id = #{id}")
    public void updateData(AttributeValue attributeValue);
}
