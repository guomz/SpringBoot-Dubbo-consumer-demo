package com.guomz.springbootdubbo.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.guomz.entity.Student;
import org.guomz.service.MyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:20880")
    private MyService myService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String callMyServiceHello(){
        String result = myService.sayHello();
        return result;
    }

    @RequestMapping(value = "/getstudent", method = RequestMethod.GET)
    public Student getStudent(){
        return myService.getStudent();
    }
}
