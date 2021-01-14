package com.fh.goods.dao;

import com.fh.goods.entity.po.Attribute;
import com.fh.goods.entity.vo.PageParam;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttributeDao {
    @Select("<script> select count(1) from goods_attribute where 1=1 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            "</script>")
    public Long queryCount(PageParam param);
    @Select("<script> select * from goods_attribute where 1=1 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            "limit #{startIndex},#{limit}  </script>")
    public List<Attribute> queryData(PageParam param);
}
