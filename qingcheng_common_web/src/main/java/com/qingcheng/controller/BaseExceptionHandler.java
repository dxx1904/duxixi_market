package com.qingcheng.controller;

import com.qingcheng.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//公共异常处理
@ControllerAdvice //控制器通知类
public class BaseExceptionHandler {
    //错误统一处理的方法
    @ExceptionHandler(Exception.class) //注解用于指定监测的异常类型，现在是所有的异常都会进行 error 方法
    //想让特定的某个异常进行只需指定特定的某个异常即可
    @ResponseBody //让它不仅执行这个方法还把结果输出到json的返回值上，这样它就可以将Result自动进行类型转换转成json
    public Result error(Exception e){
        e.printStackTrace();//将异常错误信息打印
        System.out.println("调用了异常处理");
        return new Result(1,e.getMessage());

    }
}
