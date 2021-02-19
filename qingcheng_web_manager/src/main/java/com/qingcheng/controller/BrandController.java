package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand") //做映射地址
public class BrandController {
    //调用服务
    @Reference  //注入远程的业务接口，是一种远程调用，是dubbo的注解,也是注入,它一般注入的是分布式的远程服务的对象,需要dubbo配置使用
    //注入本地的业务接口使用 Autowired
    private BrandService brandService;

    @RequestMapping("findAll") //通用的地址的映射
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/findPage") //这个方法只能是 get 方式请求
    public PageResult<Brand> findPage(int page,int size){
        System.out.println("findPage");
        return brandService.findPage(page,size);
    }

    //get方法请求可用直接通过浏览器进行请求，post方法请求需要借助 Postmanv 工具进行测试
    @PostMapping("/findList")
    public List<Brand> findList(@RequestBody Map searchMap){ //加 RequestBody 证明它是 post 传过来的对象
        return brandService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Brand> findPage(@RequestBody Map searchMap,int page,int size){
        return brandService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Brand findById(Integer id){
        return brandService.findById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){ //要给前端提示从而让前端看到方法是否成功，故定义返回对象
        //int x = 1/0;
        brandService.add(brand);
        return new Result();//不传参代表成功，要是失败会进行集中的错误出来
    }

    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        brandService.delete(id);
        return new Result();
    }
}
