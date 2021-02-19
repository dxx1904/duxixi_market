package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    public List<Brand> findAll();

    //创建返回分页数据的方法
    public PageResult<Brand> findPage(int page,int size);

    //跟据 Map 对象进行条件查询
    public List<Brand> findList(Map<String,Object> searchMap);

    //条件+分页查询
    public PageResult<Brand> findPage(Map<String,Object> searchMap,int page,int size);

    //跟据id查询品牌
    public Brand findById(Integer id);

    //品牌新增
    public void add(Brand brand);

    //品牌的修改
    public void update(Brand brand);

    //跟据id删除
    public void delete(Integer id);
}
