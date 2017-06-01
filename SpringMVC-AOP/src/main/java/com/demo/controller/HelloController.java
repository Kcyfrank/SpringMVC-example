package com.demo.controller;

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
public class HelloController {

    /**
     * HelloController 下的 public 方法
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        log.error("/hello/hello");
        return "received";
    }

    /**
     * HelloController 下的 protected 方法
     * @return
     */
    @ResponseBody
    @RequestMapping("/java")
    protected String helloJava() {
        log.error("/hello/java");
        return "received";
    }
}
