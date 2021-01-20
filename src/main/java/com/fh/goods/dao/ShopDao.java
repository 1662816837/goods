package com.fh.goods.dao;

import com.fh.goods.entity.po.Shop;
import org.apache.ibatis.annotations.Insert;

public interface ShopDao {
    @Insert("insert  into shop_commodity  (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,author,isDel)" +
            " value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel})")
    public void addData(Shop shop);
}
