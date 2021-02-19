package com.qingcheng.dao;

import com.qingcheng.pojo.goods.Brand;
import tk.mybatis.mapper.common.Mapper;

//建立了接口并让其继承mapper，它就具有增删改查的整套方法
public interface BrandMapper extends Mapper<Brand> { //指定泛型类型为实体类的类型
}
