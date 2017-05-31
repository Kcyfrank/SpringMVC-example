package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by forip on 2017/5/31.
 */

@Controller
@Slf4j
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/login")
    public String hello(){
        log.error("test!!!!!!!!!!!!!");
        return "web/jsp/login";
    }
}
