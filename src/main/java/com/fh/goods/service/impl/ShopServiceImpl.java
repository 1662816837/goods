package com.fh.goods.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.goods.dao.ProductAttrDatasDao;
import com.fh.goods.dao.ShopDao;
import com.fh.goods.entity.po.ProductAttrDatas;
import com.fh.goods.entity.po.Shop;
import com.fh.goods.entity.vo.PageParam;
import com.fh.goods.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao dao;

    @Resource
    private ProductAttrDatasDao dao2;

    @Override
    public void addData(Shop shop) {
        shop.setCreateDate(new Date());
        shop.setAuthor("admin");
        shop.setIsDel(0);
        dao.addData(shop);
    }

    @Override
    public Map queryDataLimit(PageParam param) {
        Map map = new HashMap();
        //先查询我们数据的总条数
        Long count = dao.queryCount(param);
        //构建我们的当前页的开始下标
        param.setStartIndex((param.getPage()-1)*param.getLimit());
        //查询到我们的分页数据
        List<Shop> list = dao.queryDataLimit(param);
        map.put("count",count);
        map.put("list",list);
        return map;
    }

    @Override
    public void updataData(Shop shop) {
        shop.setUpdateDate(new Date());
        shop.setAuthor("admin");
        dao.updataData(shop);
    }

    @Override
    public void updateDataById(Integer id) {
         dao.updateDataById(id);
    }

    @Override
    public void addDataSku(Shop shop, String attr, String sku) {
        //新增我们步骤一的数据  并且返回主键
        shop.setAuthor("admin");
        shop.setIsDel(0);
        shop.setCreateDate(new Date());
        dao.addData(shop);
        // 声明属性数据的对象  就是批量新增的list集合
        List<ProductAttrDatas> adList=new ArrayList<>();
        //把我们传过来的json数据转成数组  循环之后放到我们的list集合中   进行我们的数据批量新增
        //批量新增
        //将attr的json数组字符串 转为json数组对象
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i <objects.size() ; i++) {
            //构建属性数据对象
            ProductAttrDatas temp=new ProductAttrDatas();
            //设置对应的商品id
            temp.setProId(shop.getId());
            temp.setAttrData(objects.get(i).toString());
            //放入集合
            adList.add(temp);
        }

        //将sku的json数组字符串 转为json数组对象
        JSONArray objectssku = JSONObject.parseArray(sku);//将传过来的json数据  转成我们的list集合 并且循环它
        for (int i = 0; i <objectssku.size() ; i++) {
            //得到具体一个json对象
            JSONObject dataJs= (JSONObject) objectssku.get(i);
            //构建属性数据对象
            ProductAttrDatas temp=new ProductAttrDatas();
            //设置对应的商品id
            temp.setProId(shop.getId());
            temp.setPrice(dataJs.getDouble("pricess"));
            temp.setStorcks(dataJs.getInteger("storcks"));
            dataJs.remove("price");
            dataJs.remove("storck");
            temp.setAttrData(objectssku.get(i).toString());
            //放入集合
            adList.add(temp);
        }
        dao2.adds(adList);

    }

    @Override
    public Shop queryDataById(Integer id) {
        Shop shop = dao.queryDataById(id);
        return shop;
    }
}
