package com.fh.goods.dao;

import com.fh.goods.entity.po.Attribute;
import com.fh.goods.entity.vo.PageParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttributeDao {
    @Select("<script> select count(1) from goods_attribute where 1=1 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            " and isDel = 0 </script>")
    public Long queryCount(PageParam param);
    @Select("<script> select * from goods_attribute where 1=1 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            " and isDel = 0 " +
            "limit #{startIndex},#{limit}    </script>")
    public List<Attribute> queryData(PageParam param);
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into goods_attribute (name,nameCH,typeId,type,isSKU,isDel,createDate,author) values (#{name},#{nameCH},#{typeId},#{type},#{isSKU},#{isDel},#{createDate},#{author})")
    public void addData(Attribute attribute);
    @Update("update  goods_attribute set name = #{name},nameCH = #{nameCH},typeId = #{typeId},type = #{type},isSKU = #{isSKU},author = #{author},updateDate = #{updateDate} where id = #{id}")
    public void updateData(Attribute attribute);
    @Update("update goods_attribute set isDel=1 where id=#{id}")
    public void updateDataById(Integer id);
    @Select("select * from goods_attribute where id = #{id}")
    public Attribute queryDataById(Integer id);
    @Select("select * from goods_attribute where typeId = #{typeId}")
    public List<Attribute> queryDataBuTypeId(Integer typeId);
}
