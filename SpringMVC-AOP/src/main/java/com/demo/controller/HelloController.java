package com.demo.controller;

import com.demo.annotation.AopClassAnno;
import com.demo.annotation.AopMethodAnno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by forip on 2017/5/31.
 */

@Controller
@Slf4j
@RequestMapping("/hello")
@AopClassAnno(testString = "testClassAnno")
public class HelloController {

    /**
     * HelloController 下的 public 方法
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        log.error("path: A:Hello! B:Hello to you too!");
        return "received";
    }

    @ResponseBody
    @RequestMapping("/world")
    public String world(String prarm1, int param2, String param3) {
        log.error("path: Hello World!");
        return "received";
    }

    /**
     * HelloController 下的 protected 方法
     * @return
     */
    @AopMethodAnno(testString = "is a test")
    @ResponseBody
    @RequestMapping("/java")
    protected String helloJava() {
        log.error("path: Hello Java!");
        return "received";
    }
}
