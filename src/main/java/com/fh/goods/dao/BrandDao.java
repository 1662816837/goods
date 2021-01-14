package com.fh.goods.dao;

import com.fh.goods.entity.po.Brand;
import com.fh.goods.entity.vo.PageParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface BrandDao {
    @Select("<script> select count(1) from goods_brand where 1=1 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            "</script>")
    public Long queryCount(PageParam param);
    @Select("<script> select * from goods_brand where 1=1 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            " order by ord  limit #{startIndex},#{limit}  </script>")
    public List<Brand> queryData(PageParam param);

    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into goods_brand (name,bandE,imgpath,bandDesc,ord,isdel,createDate,author) values (#{name},#{bandE},#{imgpath},#{bandDesc},#{ord},#{isdel},#{createDate},#{author})")
    public Integer addData(Brand brand);
    @Update("update  goods_brand set name = #{name},bandE = #{bandE},imgpath = #{imgpath},bandDesc = #{bandDesc},ord = #{ord},author = #{author},updateDate = #{updateDate} where id = #{id}")
    public void updateDate(Brand brand);
    @Update("update goods_brand set isdel = #{isdel} where id = #{id} ")
    public void updateDateFalse(Brand brand);
    @Select("select * from goods_brand where id = #{id}")
    public Brand queryDataById(Integer id);
}
