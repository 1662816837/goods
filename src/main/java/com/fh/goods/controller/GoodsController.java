package com.fh.goods.controller;

import com.fh.goods.entity.po.Goods;
import com.fh.goods.entity.vo.ReponseData;
import com.fh.goods.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("GoodsController")
@CrossOrigin//这个注解是用来解决跨域问题的
public class GoodsController {
    @Resource
    private GoodsService ser;

    /*1    查询所有的分类数据
    路径   http://ip:port/api/type/getData
    // ,get请求,返回值   {"code":200,"message":"提示",data:[{*}]}*/
    @GetMapping("getData")
    public ReponseData queryData(){
        List<Goods> list = ser.queryData();
        return ReponseData.success(list);
    }

    /*2    查询指定pid的数据
    路径   http://ip:port/api/type/getDataByPid
    get请求,参数    pid ,返回值   {"code":200,"message":"提示",data:[{*}]}*/
    @GetMapping("getDataByPid")
    public ReponseData queryDataByPid(Integer pid){
        if(pid==null){
            return ReponseData.error("pid为必传项 请重新发送请求");
        }
        List<Goods> list = ser.queryDataByPid(pid);
        return ReponseData.success(list);
    }

  /*  3  新增分类
    路径   http://ip:port/api/type/add
    post请求,参数    pid    name
    返回值    {code:"",message:"",data:新增的id}*/
  @PostMapping("add")
  public ReponseData addData(Goods goods){
      if (goods.getPid()==null){
          return ReponseData.error("pid为必传项 请重新发送请求");
      }
      if (goods.getName()==null){
          return ReponseData.error("name为必传项 请重新发送请求");
      }
      goods.setAuthor("admin");
      Integer id = ser.addData(goods);

      return ReponseData.success(id);
  }


/*4   修改
    路径   http://ip:port/api/type/update
    post请求,参数   id （必传）     pid   name  isDel
    返回值     {code:"",message:""}*/
@PostMapping("update")
public ReponseData updateData(Goods goods){
    if (goods.getId()==null){
        return ReponseData.error("id为必传项 请重新发送请求");
    }
    Goods goo = ser.queryDataById(goods.getId());
    if (goods.getName()!=null && goods.getName()!=""){
        goo.setName(goods.getName());
    }
    if (goods.getPid()!=null){
        goo.setPid(goods.getPid());
    }
    if (goods.getIsDel()!=null && 0!=goods.getIsDel()){
        goo.setIsDel(1);
    }
    goo.setUpdateDate(new Date());
    goo.setAuthor("admin");
    ser.updateData(goo);
    return ReponseData.success(null);
}
}
