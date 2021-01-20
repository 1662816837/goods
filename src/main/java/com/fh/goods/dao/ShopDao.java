package com.fh.goods.dao;

import com.fh.goods.entity.po.Shop;
import com.fh.goods.entity.vo.PageParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopDao {
    @Insert("insert  into shop_commodity  (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,author,isDel)" +
            " value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel})")
    public void addData(Shop shop);
    @Select("<script> select count(1) from shop_commodity where 1=1 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            " and isDel = 0 </script>")
    public Long queryCount(PageParam param);
    @Select("<script> select * from goods_attribute where 1=1 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            " and isDel = 0 " +
            "limit #{startIndex},#{limit}    </script>")
    public List<Shop> queryDataLimit(PageParam param);
}
