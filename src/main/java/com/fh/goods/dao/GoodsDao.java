package com.fh.goods.dao;

import com.fh.goods.entity.po.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsDao {
    @Select("select * from goods_type where 1=1 and isDel = 0")
    public List<Goods> queryData();
    @Select("select * from goods_type where 1=1 and pid = #{pid} and isDel = 0")
    public List<Goods> queryDataByPid(Integer pid);
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into goods_type (name,pid,createDate,isDel,author) values (#{name},#{pid},#{createDate},#{isDel},#{author})")
    public Integer addData(Goods goods);
    @Select("select * from goods_type where 1=1 and id=#{id} ")
    public Goods queryDataById(Integer id);
    @Update("update goods_type set name=#{name},pid=#{pid},isDel=#{isDel},author=#{author},updateDate=#{updateDate} where id = #{id}")
    public void updateData(Goods goo);
}
