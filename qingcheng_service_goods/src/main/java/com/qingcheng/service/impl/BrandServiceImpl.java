package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service //选择dubbo下的Service注解
public class BrandServiceImpl implements BrandService {
    //在服务层中需要调用数据访问层
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll(); //它已经帮我们实现了很多常用的方法，selectAll()查询全部数据
    }

    //分页服务的实现
    @Override
    public PageResult<Brand> findPage(int page, int size) {
        //PageHelper起到拦截的作用，从而实现分页
        PageHelper.startPage(page,size);
        //Page 是分页插件提供的类
        Page<Brand> pageResult  = (Page<Brand>)brandMapper.selectAll();
        //把pageResult这两个属性取出来封装PageResult对象
        return new PageResult<Brand>(pageResult.getTotal(),pageResult.getResult());
    }

    //条件查询
    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        //下面的逻辑具有一定通用性，可封装成方法
       /* Example example = new Example(Brand.class);//参数为查询类的 class
        //加上查询条件
        Example.Criteria criteria = example.createCriteria();
        //确保对象不为空在进行查询，若为空进行无条件查询
        if(searchMap!=null){
            if(searchMap.get("name")!=null&!"".equals(searchMap.get("name"))){
                //进行模糊查询
                criteria.andLike("name","%"+(String) searchMap.get("name")+"%");
            }
            if(searchMap.get("letter")!=null&!"".equals(searchMap.get("letter"))){
                //首字母进行匹配查询
                criteria.andEqualTo("letter",(String) searchMap.get("letter"));
            }
        }*/
        Example example = createExample(searchMap);

        //Example是查询条件的封装对象
        return brandMapper.selectByExample(example);
    }

    //实现条件+分页查询
    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Brand> pageResult=(Page<Brand>)brandMapper.selectByExample(example);
        return new PageResult<>(pageResult.getTotal(),pageResult.getResult());
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand); //insert插入就是表示新增
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }


    public Example createExample(Map<String, Object> searchMap) {
        //下面的逻辑具有一定通用性，可封装成方法
        Example example = new Example(Brand.class);//参数为查询类的 class
        //加上查询条件
        Example.Criteria criteria = example.createCriteria();
        //确保对象不为空在进行查询，若为空进行无条件查询
        if(searchMap!=null){
            if(searchMap.get("name")!=null&!"".equals(searchMap.get("name"))){
                //进行模糊查询
                criteria.andLike("name","%"+(String) searchMap.get("name")+"%");
            }
            if(searchMap.get("letter")!=null&!"".equals(searchMap.get("letter"))){
                //首字母进行匹配查询
                criteria.andEqualTo("letter",(String) searchMap.get("letter"));
            }
        }

        return example;
    }


}
